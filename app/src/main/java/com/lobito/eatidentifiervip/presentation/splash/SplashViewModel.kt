package com.lobito.eatidentifiervip.presentation.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    var state by mutableStateOf(false)
        private set

//    init {
//        navigateHome()
//    }

    fun navigateHome() {
        viewModelScope.launch {
            delay(3000)
            state = true
        }
    }
}

