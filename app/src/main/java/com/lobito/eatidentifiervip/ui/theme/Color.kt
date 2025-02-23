package com.lobito.eatidentifiervip.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Black = Color(0xFF000113)
val DarkOrange = Color(0xFFB34700) // Un color oscuro anaranjado
val LightOrange = Color(0xFFFFE5B4) // Un color claro anaranjado
val MediumOrange = Color(0xFFFFA500) // Un color medio anaranjado

val ColorScheme.focusedTextFieldText
    @Composable
    get() = if (isSystemInDarkTheme()) Color.White else DarkOrange

val ColorScheme.unfocusedTextFieldText
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFFFDAB9) else MediumOrange

val ColorScheme.textFieldContainer
    @Composable
    get() = if (isSystemInDarkTheme()) DarkOrange.copy(alpha = 0.6f) else LightOrange