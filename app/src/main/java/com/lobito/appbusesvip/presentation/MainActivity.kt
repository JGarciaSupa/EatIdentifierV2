package com.lobito.appbusesvip.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.lobito.appbusesvip.ui.theme.AppBusesVIPTheme
import com.lobito.utilscalera.data.core.navigation.NavigationWrapper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppBusesVIPTheme {
                NavigationWrapper()
            }
        }
    }
}

