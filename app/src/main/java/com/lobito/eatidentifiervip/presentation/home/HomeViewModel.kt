package com.lobito.eatidentifiervip.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lobito.eatidentifiervip.data.common.Resource
import com.lobito.eatidentifiervip.domain.usecase.empleados.GetEmpleadoByCuiUseCase
import com.lobito.eatidentifiervip.domain.usecase.empleados.GetEmpleadosFromApiUseCase
import com.lobito.eatidentifiervip.domain.usecase.empleados.GetEmpleadosFromDBUseCase
import com.lobito.eatidentifiervip.domain.usecase.empleados.InsertEmpleadoUseCase
import com.lobito.eatidentifiervip.domain.usecase.printer.PrintUseCase
import com.lobito.eatidentifiervip.presentation.widget.ToastyViewModelHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
               toastyHelper.triggerToastyInfo("Usuario encontrado 😊")

            } catch (e: Exception) {
                toastyHelper.triggerToastyError(e.toString())
            }
        }

    }

}