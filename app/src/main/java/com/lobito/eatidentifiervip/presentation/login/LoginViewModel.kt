package com.lobito.eatidentifiervip.presentation.login

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.WorkManager
import com.lobito.eatidentifiervip.data.common.Resource
import com.lobito.eatidentifiervip.data.common.Resource.Success
import com.lobito.eatidentifiervip.data.remote.worker.SyncManager
import com.lobito.eatidentifiervip.di.Qualifiers
import com.lobito.eatidentifiervip.domain.model.Session
import com.lobito.eatidentifiervip.domain.model.User
import com.lobito.eatidentifiervip.domain.usecase.empresas.GetEmpresasUseCase
import com.lobito.eatidentifiervip.domain.usecase.user.PostLoginUseCase
import com.lobito.eatidentifiervip.presentation.login.state.EmpresasState
import com.lobito.eatidentifiervip.presentation.login.state.LoginState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel(
    private val context : Context,
    private val getEmpresasUseCase: GetEmpresasUseCase,
    private val postLoginUseCase: PostLoginUseCase,
) : ViewModel() {

    var stateLogin by mutableStateOf(LoginState())
        private set

    var empresaState by mutableStateOf(EmpresasState())
        private set

    init {
        getEmpresas()  // Cargar las empresas al iniciar el ViewModel
    }

    fun getEmpresas() {
        viewModelScope.launch(Dispatchers.IO){
            getEmpresasUseCase().collect { empresas ->
                empresaState = empresaState.copy(
                    empresas = empresas,
                    isLoading = false,
                    error = if (empresas.isEmpty()) "No se encontraron empresas 😞" else ""
                )
            }
        }
        }

    fun login(userName: String, password: String, idEmpresa: String) {
        viewModelScope.launch(Dispatchers.IO){
            val session = Session(
                email = userName,
                password = password,
                idEmpresa = idEmpresa,
            )
           val response = postLoginUseCase(session)
            when(response){
                is Success -> {
                    stateLogin = stateLogin.copy(
                        isLoading = false,
                        error = "",
                        data = response.data
                    )
                    restartTokenSync()
                }
                is Resource.Error -> {
                    stateLogin = stateLogin.copy(
                        isLoading = false,
                        error = response.message ?: "Ocurrió un error desconocido"
                    )
                }
                is Resource.Loading -> {
                    stateLogin = stateLogin.copy(
                        isLoading = true,
                        error = ""
                    )
                }
            }
        }
    }


    // ESTA FUNCION SERA PARA REFRESCAR EL TOKEN Y SUS DATOS CORRESPONDIENTES
    fun restartTokenSync() {
        Log.i("SyncManager", "Reiniciando WorkManager")
        // Cancelar la tarea periódica existente
        WorkManager.getInstance(context).cancelUniqueWork(Qualifiers.tokenSyncWorker.toString())
        // Volver a programarla
        SyncManager.scheduleTokenSync(context)
    }


}
