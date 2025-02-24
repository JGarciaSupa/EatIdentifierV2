package com.lobito.eatidentifiervip.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lobito.eatidentifiervip.domain.usecase.empleados.GetEmpleadoByCuiUseCase
import com.lobito.eatidentifiervip.domain.usecase.empleados.GetEmpleadosUseCase
import com.lobito.eatidentifiervip.domain.usecase.printer.PrintUseCase
import com.lobito.eatidentifiervip.presentation.widget.ToastyViewModelHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getEmpleadosUseCase: GetEmpleadosUseCase,
    private val getEmpleadoByCuiUseCase: GetEmpleadoByCuiUseCase,
    private val printUseCase: PrintUseCase,
) : ViewModel() {

    //Widget Toasty
    private val toastyHelper = ToastyViewModelHelper(viewModelScope)
    val toastMessageError = toastyHelper.toastMessageError
    val toastMessageSuccess = toastyHelper.toastMessageSuccess
    val toastMessageInfo = toastyHelper.toastMessageInfo

    init{
        getEmpleados()
    }

    fun getEmpleados(){
        viewModelScope.launch(Dispatchers.IO) {
          getEmpleadosUseCase().collect { empleados ->
              if (empleados.isNotEmpty()) {
                  Log.i("TAG", "getEmpleados: obtuvo Empleados")
              } else {
                  Log.i("TAG", "getEmpleados: No obtuvo Empleados")
              }
          }
        }
    }

    fun findClient(dni : String){
        if(dni.isEmpty()){
            toastyHelper.triggerToastyInfo("Ingrese un DNI \uD83E\uDDD0")
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



            } catch (e: Exception) {
                toastyHelper.triggerToastyError(e.toString())
            }
        }

    }

}