package com.lobito.eatidentifiervip.presentation.login

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.WorkManager
import com.lobito.eatidentifiervip.data.remote.worker.SyncManager
import com.lobito.eatidentifiervip.di.Qualifiers
import com.lobito.eatidentifiervip.domain.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel(
    private val context : Context,
) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    fun login(username: String, password: String) {
        viewModelScope.launch {
            state = state.copy(isloading = true)
            Log.i("TAG", "login: $username $password")
            delay(5000)
            if(username == "a" && password == "a") {

                state = state.copy(
                    user = User(0L,username, password),
                    isloading = false
                )
            } else {
                state = state.copy(
//                    isError = "Usuario o contraseña incorrectos",
                    isloading = false
                )
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
