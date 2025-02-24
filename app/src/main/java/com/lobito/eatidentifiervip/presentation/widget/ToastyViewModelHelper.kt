package com.lobito.eatidentifiervip.presentation.widget

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ToastyViewModelHelper(private val scope: CoroutineScope) {

    private val _toastMessageSuccess = MutableStateFlow<String?>(null)
    val toastMessageSuccess: StateFlow<String?> = _toastMessageSuccess

    private val _toastMessageError = MutableStateFlow<String?>(null)
    val toastMessageError: StateFlow<String?> = _toastMessageError

    private val _toastMessageInfo = MutableStateFlow<String?>(null)
    val toastMessageInfo: StateFlow<String?> = _toastMessageInfo

    fun triggerToastyError(message: String) {
        scope.launch {
            _toastMessageError.update { message }
            delay(200)
            _toastMessageError.update { null }
        }
    }

    fun triggerToastySuccess(message: String) {
        scope.launch {
            _toastMessageSuccess.update { message }
            delay(200)
            _toastMessageSuccess.update { null }
        }
    }

    fun triggerToastyInfo(message: String) {
        scope.launch {
            _toastMessageInfo.update { message }
            delay(200)
            _toastMessageInfo.update { null }
        }
    }

}
