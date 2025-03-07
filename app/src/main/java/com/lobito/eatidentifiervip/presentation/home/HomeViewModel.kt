package com.lobito.eatidentifiervip.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lobito.eatidentifiervip.data.common.Resource
import com.lobito.eatidentifiervip.di.PrinterType
import com.lobito.eatidentifiervip.di.Qualifiers
import com.lobito.eatidentifiervip.domain.model.Empleado
import com.lobito.eatidentifiervip.domain.model.HistoricoImpresion
import com.lobito.eatidentifiervip.domain.model.PrintData
import com.lobito.eatidentifiervip.domain.usecase.empleados.GetEmpleadoByCuiUseCase
import com.lobito.eatidentifiervip.domain.usecase.empleados.GetEmpleadosFromApiUseCase
import com.lobito.eatidentifiervip.domain.usecase.empleados.GetEmpleadosFromDBUseCase
import com.lobito.eatidentifiervip.domain.usecase.empleados.InsertEmpleadoUseCase
import com.lobito.eatidentifiervip.domain.usecase.historico.GetHistoricoByEmpleadoUseCase
import com.lobito.eatidentifiervip.domain.usecase.historico.HistoricoImpresionUseCase
import com.lobito.eatidentifiervip.domain.usecase.printer.PrintUseCase
import com.lobito.eatidentifiervip.domain.usecase.ticket.TicketModelOneUseCase
import com.lobito.eatidentifiervip.domain.usecase.ticket.TicketPresentationUseCase
import com.lobito.eatidentifiervip.presentation.widget.ToastyViewModelHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class HomeViewModel(
    private val getEmpleadosFromDBUseCase: GetEmpleadosFromDBUseCase,
    private val getEmpleadoByCuiUseCase: GetEmpleadoByCuiUseCase,
    private val getEmpleadoFromApiUseCase: GetEmpleadosFromApiUseCase,
    private val insertEmpleado: InsertEmpleadoUseCase,
    private val printUseCase: PrintUseCase,
    private val ticketPresentationUseCase: TicketPresentationUseCase,
    private val ticketModelOneUseCase : TicketModelOneUseCase,
    private val historicoImpresionUseCase: HistoricoImpresionUseCase,
    private val getHistoricoByEmpleadoUseCase : GetHistoricoByEmpleadoUseCase,
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

                val (esValido, mensaje) = validarRegistroComida(result.idEmpleado)

                if (!esValido) {
                    toastyHelper.triggerToastyError(mensaje ?: "Error desconocido")
                    return@launch
                }

                // Si pasó la validación, se imprime el ticket


                val ticketPresentation = ticketPresentationUseCase
                val ticketEmpleado = ticketModelOneUseCase(empleado = result, tipoComida = mensaje!!)
                val historico = HistoricoImpresion(
                    cui = result.cui,
                    idEmpleado = result.idEmpleado,
                    tipoComida = mensaje,
                    observaciones = "",
                    message = "",
                )
                historicoImpresionUseCase(historico)
//                val printData = PrintData(text = ticketArmado, dni = "12345678")
//                printUseCase(printData, PrinterType.BLUETOOTH)

            } catch (e: Exception) {
                toastyHelper.triggerToastyError(e.toString())
            }
        }

    }

    private suspend fun validarRegistroComida(idEmpleado: String): Pair<Boolean, String?> {
        val currentTime = Calendar.getInstance()
        val hour = currentTime.get(Calendar.HOUR_OF_DAY)
        val minute = currentTime.get(Calendar.MINUTE)

        // Determinar el tipo de comida basado en la hora
        val tipoComida = when {
            (hour in 7..9) || (hour == 10 && minute == 0) -> "DESAYUNO"
            (hour in 12..13) || (hour == 14 && minute == 0) -> "ALMUERZO"
            (hour in 17..18) || (hour == 19 && minute == 0) -> "CENA"
            else -> return Pair(false, "No es horario de comida 😞")
        }

        // Formatear la fecha actual solo con "yyyy-MM-dd" para comparar con la base de datos
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

        // Buscar si ya existe un registro de comida para el empleado en la fecha actual
        val existingTicket = getHistoricoByEmpleadoUseCase(idEmpleado = idEmpleado,fecha = today, tipoComida = tipoComida)

        if (existingTicket != null) {
            return Pair(false, "Ya se registró un ticket de $tipoComida hoy 😞")
        }

        return Pair(true, tipoComida) // Devuelve true y el tipo de comida válido
    }



}