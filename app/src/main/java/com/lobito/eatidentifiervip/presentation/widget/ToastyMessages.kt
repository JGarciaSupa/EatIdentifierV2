package com.lobito.eatidentifiervip.presentation.widget

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import es.dmoral.toasty.Toasty
import kotlinx.coroutines.flow.StateFlow

@Composable
fun ToastyMessages(
    errorMessageFlow: StateFlow<String?>,
    successMessageFlow: StateFlow<String?>,
    infoMessageFlow: StateFlow<String?>
) {
    val context = LocalContext.current

    val errorMessage by errorMessageFlow.collectAsState()
    val successMessage by successMessageFlow.collectAsState()
    val infoMessage by infoMessageFlow.collectAsState()

    LaunchedEffect(errorMessage) {
        errorMessage?.let { message ->
            Toasty.error(context, message, Toast.LENGTH_SHORT, true).show()
        }
    }

    LaunchedEffect(successMessage) {
        successMessage?.let { message ->
            Toasty.success(context, message, Toast.LENGTH_SHORT, true).show()
        }
    }

    LaunchedEffect(infoMessage) {
        infoMessage?.let { message ->
            Toasty.info(context, message, Toast.LENGTH_SHORT, true).show()
        }
    }
}