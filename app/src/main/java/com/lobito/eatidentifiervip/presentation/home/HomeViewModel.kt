package com.lobito.eatidentifiervip.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lobito.eatidentifiervip.data.common.Resource
import com.lobito.eatidentifiervip.di.PrinterType
import com.lobito.eatidentifiervip.di.Qualifiers
import com.lobito.eatidentifiervip.domain.model.Empleado
import com.lobito.eatidentifiervip.domain.model.PrintData
import com.lobito.eatidentifiervip.domain.usecase.empleados.GetEmpleadoByCuiUseCase
import com.lobito.eatidentifiervip.domain.usecase.empleados.GetEmpleadosFromApiUseCase
import com.lobito.eatidentifiervip.domain.usecase.empleados.GetEmpleadosFromDBUseCase
import com.lobito.eatidentifiervip.domain.usecase.empleados.InsertEmpleadoUseCase
import com.lobito.eatidentifiervip.domain.usecase.printer.PrintUseCase
import com.lobito.eatidentifiervip.presentation.widget.ToastyViewModelHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HomeViewModel(
    private val getEmpleadosFromDBUseCase: GetEmpleadosFromDBUseCase,
    private val getEmpleadoByCuiUseCase: GetEmpleadoByCuiUseCase,
    private val getEmpleadoFromApiUseCase: GetEmpleadosFromApiUseCase,
    private val insertEmpleado: InsertEmpleadoUseCase,
    private val printUseCase: PrintUseCase,
) : ViewModel() {

    //Widget Toasty
    private val toastyHelper = ToastyViewModelHelper(viewModelScope)
    val toastMessageError = toastyHelper.toastMessageError
    val toastMessageSuccess = toastyHelper.toastMessageSuccess
    val toastMessageInfo = toastyHelper.toastMessageInfo

    init {
        getEmpleadoFromApi()
    }

    private fun getEmpleadoFromApi(){
        viewModelScope.launch(Dispatchers.IO) {
           val response = getEmpleadoFromApiUseCase()
            when(response){
                is Resource.Success -> {
                   insertEmpleado(response.data)
                }
                is Resource.Error -> {
                    toastyHelper.triggerToastyError(response.message.toString())
                }
                else ->{

                }
            }
        }
    }

    fun ticketEmpleado(empleado: Empleado): String {
        val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())

        return """
        -----------------------------
              ACCESO AUTORIZADO      
        -----------------------------
        DNI: ${empleado.cui}  
        Hora: $currentTime  
        Nombre: ${empleado.nombre}  
        Posición: ${empleado.cargo}  
        ----------------------------- 
    """.trimIndent()
    }

    fun ticketTest(): String {
        val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())

        return """
        -----------------------------
              ACCESO AUTORIZADO      
        -----------------------------
        DNI: 12345678  
        Hora: $currentTime  
        Nombre: Juan Perez  
        Posición: Supervisor  
        ----------------------------- 
    """.trimIndent()
    }

    fun imprimir(){
        viewModelScope.launch(Dispatchers.IO) {
            val printData = PrintData(text = ticketTest(), dni = "12345678")
            printUseCase(printData, PrinterType.BLUETOOTH)
        }
    }

    fun findClient(dni : String){
        if(dni.isEmpty()){
            toastyHelper.triggerToastyInfo("Ingrese un DNI")
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = getEmpleadoByCuiUseCase(dni)
                if (result == null) {
                    toastyHelper.triggerToastyError("No se encontró el usuario 😞")
                    return@launch
                }
                if(result.estado != 0){
                 toastyHelper.triggerToastyInfo("Usuario Bloqueado 😞, Notifique al Supervisor")
                    return@launch
                }
                /***
                 * REALIZAR VALIDACION DE TIEMPO SI DEBE IMPRIMIR DESAYUNO O ALMUERZO O CENA
                 * AHORA SI VUELVE A IMPRIMIR UN HORARIO DE RANGO 6:00 AM A 10:00 AM SOLO ES DESAYUNO Y SOLO 1 VEZ
                 * SI VUELVE EL SISTEMA INDICARA MOSTRARA UN ALERT QUE YA FUE IMPRIMIDO SU TICKET
                 * SUCESIVAMENTE PARA ALMUERZO Y CENA
                 * NO DIRA ACCESO AUTORIZADO, DEBERA DECIR SI ES DESAYUNO, ALMUERZO O CENA
                 *
                 * TODO : ESTA PENDIENTE HACER AUTOMATICO LA LECTURA Y EJECUTAR LA LOGICA DE IMPRESION
                 */

                val ticketArmado = ticketEmpleado(result)
                val printData = PrintData(text = ticketArmado, dni = "12345678")
                printUseCase(printData, PrinterType.BLUETOOTH)

            } catch (e: Exception) {
                toastyHelper.triggerToastyError(e.toString())
            }
        }

    }

}