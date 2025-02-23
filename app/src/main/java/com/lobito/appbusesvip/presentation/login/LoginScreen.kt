package com.lobito.appbusesvip.presentation.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.lobito.appbusesvip.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
//    navigateToHome: () -> Unit
) {
//    val viewModel = viewModel<LoginViewModel>()
    val viewModel: LoginViewModel = koinViewModel()

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Header()
        Spacer(modifier = Modifier.weight(1f))
        Body(viewModel)
        Spacer(modifier = Modifier.weight(1f))
        Footer()
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun Header() {
    // Lógica para mostrar el Lottie
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie_login))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}

@Composable
fun Body(viewModel: LoginViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val state = viewModel.state // Observar el estado

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Usuario") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            enabled = !state.isloading, // Deshabilita mientras está cargando
            onClick = {
               viewModel.login(username, password) //  viewModel.restartTokenSync()
                      },
            modifier = Modifier.fillMaxWidth()
        ) {
            if (state.isloading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = Color.White,
                    strokeWidth = 2.dp
                )
            } else {
                Text("Login")
            }
        }
    }
}


@Composable
fun Footer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Text("Versión: 1.0.0")
    }
}