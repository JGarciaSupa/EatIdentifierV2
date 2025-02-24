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
import com.lobito.eatidentifiervip.domain.usecase.empresas.GetEmpresasFromApiUseCase
import com.lobito.eatidentifiervip.domain.usecase.empresas.GetEmpresasUseCase
import com.lobito.eatidentifiervip.domain.usecase.empresas.InsertEmpresasUseCase
import com.lobito.eatidentifiervip.domain.usecase.user.LoginAutomaticUseCase
import com.lobito.eatidentifiervip.domain.usecase.user.PostLoginUseCase
import com.lobito.eatidentifiervip.presentation.login.state.EmpresasState
import com.lobito.eatidentifiervip.presentation.login.state.LoginState
import com.lobito.eatidentifiervip.presentation.widget.ToastyViewModelHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.core.component.getScopeId

class LoginViewModel(
    private val context : Context,
    private val getEmpresasUseCase: GetEmpresasUseCase,
    private val getEmpresasFromApiUseCase: GetEmpresasFromApiUseCase,
    private val insertEmpresasUseCase: InsertEmpresasUseCase,
    private val postLoginUseCase: PostLoginUseCase,
    private val loginAutomaticUseCase: LoginAutomaticUseCase,
) : ViewModel() {

    private val toastyHelper = ToastyViewModelHelper(viewModelScope)
    val toastMessageError = toastyHelper.toastMessageError
    val toastMessageSuccess = toastyHelper.toastMessageSuccess
    val toastMessageInfo = toastyHelper.toastMessageInfo

    var stateLogin by mutableStateOf(LoginState())
        private set

    var empresaState by mutableStateOf(EmpresasState())
        private set

    var navigate by mutableStateOf(false)
        private set

    init {
        loginAutomatic()
        getEmpresasFromApi()
        getEmpresas()
    }

    fun getEmpresasFromApi() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = getEmpresasFromApiUseCase()
            when (response) {
                is Resource.Success -> {
                    insertEmpresasUseCase(response.data)
                }

                is Resource.Error -> {
                    empresaState = empresaState.copy(
                        isLoading = false,
                        error = response.message
                    )
                    toastyHelper.triggerToastyError(response.message)
                }

                is Resource.Loading -> {
                    empresaState = empresaState.copy(
                        isLoading = true,
                        error = ""
                    )
                }
            }
        }
    }

    fun getEmpresas() {
        viewModelScope.launch(Dispatchers.IO) {
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
        if(userName.isEmpty() || password.isEmpty() || idEmpresa.isEmpty()){
            toastyHelper.triggerToastyInfo("Ingrese todos los campos")
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            val session = Session(
                email = userName,
                password = password,
                idEmpresa = idEmpresa,
            )
            val response = postLoginUseCase(session)
            when (response) {
                is Success -> {
                    navigate = true
                }

                is Resource.Error -> {
                    stateLogin = stateLogin.copy(
                        isLoading = false,
                    )
                    toastyHelper.triggerToastyError(response.message)
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

    fun loginAutomatic() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = loginAutomaticUseCase()
            when (response) {
                is Resource.Success -> {
                    navigate = true
                }

                is Resource.Error -> {
                    stateLogin = stateLogin.copy(
                        isLoading = false,
                    )
//                        toastyHelper.triggerToastyError(response.message)
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
}

