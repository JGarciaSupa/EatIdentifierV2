package com.lobito.eatidentifiervip.presentation.splash

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.lobito.eatidentifiervip.R

@Composable
fun SplashScreen(navigateToHome: () -> Unit) {
    // Lottie Animation
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie_splash))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

//    // Navegar automáticamente después de 3 segundos
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(3000) // 3 segundos
        navigateToHome()
    }

    // Contenido de la pantalla
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Spacer(modifier = Modifier.weight(1f))
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier.fillMaxSize()
        )
//        Spacer(modifier = Modifier.weight(1f))
    }
}
