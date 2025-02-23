package com.lobito.eatidentifiervip.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.lobito.eatidentifiervip.R
import com.lobito.eatidentifiervip.domain.model.Empresa
import com.lobito.eatidentifiervip.ui.theme.Black
import com.lobito.eatidentifiervip.ui.theme.MediumOrange
import com.lobito.eatidentifiervip.ui.theme.Roboto
import com.lobito.eatidentifiervip.ui.theme.focusedTextFieldText
import com.lobito.eatidentifiervip.ui.theme.textFieldContainer
import com.lobito.eatidentifiervip.ui.theme.unfocusedTextFieldText
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    onNavigate: () -> Unit
) {
    val viewModel: LoginViewModel = koinViewModel()

    Surface {
        Column(modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()) {
            TopSection()
            Spacer(modifier = Modifier.height(36.dp))
            LoginContent(viewModel, onNavigate)
        }
    }
}

@Composable
private fun LoginContent(viewModel: LoginViewModel, onNavigate: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp)
    ) {
        val selectedEmpresa = remember { mutableStateOf<Empresa?>(null) }
        SelectEmpresa(viewModel, selectedEmpresa)
        Spacer(modifier = Modifier.height(30.dp))
        LoginSection(viewModel, selectedEmpresa.value, onNavigate)
        Spacer(modifier = Modifier.height(30.dp))
        FooterSection()
    }
}

@Composable
private fun LoginSection(viewModel: LoginViewModel, selectedEmpresa: Empresa?, onNavigate: () -> Unit = {}) {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.DarkGray

    val loginState = viewModel.stateLogin

    Spacer(modifier = Modifier.height(16.dp))

    // Input de usuario
    CustomTextField(
        value = username,
        onValueChange = { username = it },
        label = "Usuario",
        uiColor = uiColor
    )

    Spacer(modifier = Modifier.height(16.dp))

    CustomTextField(
        value = password,
        onValueChange = { password = it },
        label = "Contraseña",
        uiColor = uiColor,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    painter = painterResource(id = if (passwordVisible) R.drawable.visibility else R.drawable.visibilityoff),
                    contentDescription = null
                )
            }
        }
    )

    Spacer(modifier = Modifier.height(25.dp))

    // Botón de login
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        onClick = {
            viewModel.login(userName = username, password = password, idEmpresa = selectedEmpresa?.idEmpresa ?: "")
        },
        enabled = !loginState.isLoading,  // Deshabilitar mientras carga el login
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) MediumOrange else MediumOrange,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        if (loginState.isLoading) {
            CircularProgressIndicator(color = Color.White, modifier = Modifier.size(20.dp))
        } else {
            Text(
                text = "Ingresar",
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Medium)
            )
        }
    }
}

@Composable
private fun SelectEmpresa(viewModel: LoginViewModel, selectedEmpresa: MutableState<Empresa?>) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.DarkGray

    val empresaState = viewModel.empresaState

    Spacer(modifier = Modifier.height(20.dp))

    // Selector de empresas
    Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth(),
            enabled = !empresaState.isLoading  // Desactivar mientras carga las empresas
        ) {
            Text(
                text = selectedEmpresa.value?.razonSocial ?: "Selecciona una empresa",
                color = uiColor
            )
        }
        DropdownMenu(
            modifier = Modifier
                .fillMaxWidth(),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            when {
                empresaState.isLoading -> {
                    DropdownMenuItem(
                        onClick = { expanded = false },
                        text = { Text(text = "Cargando empresas...") }
                    )
                }
                empresaState.error.isNotBlank() -> {
                    DropdownMenuItem(
                        onClick = { expanded = false },
                        text = { Text(text = empresaState.error) }
                    )
                }
                else -> {
                    empresaState.empresas.forEach { empresa ->
                        DropdownMenuItem(
                            onClick = {
                                selectedEmpresa.value = empresa
                                expanded = false
                            },
                            text = { Text(text = empresa.razonSocial) }
                        )
                    }
                }
            }
        }
    }
}


@Composable
private fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    uiColor: Color,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: (@Composable () -> Unit)? = null
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label, style = MaterialTheme.typography.labelMedium, color = uiColor) },
        colors = TextFieldDefaults.colors(
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
            focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextFieldText,
            unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
            focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .height(55.dp)
            .background(Color(0xFFEFEEEE)),
        visualTransformation = visualTransformation,
        trailingIcon = trailingIcon,
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next
        ),
    )
}

@Composable
private fun FooterSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF94A3B8),
                        fontSize = 14.sp,
                        fontFamily = Roboto,
                        fontWeight = FontWeight.Normal
                    )
                ) {
                    append("Cambiar modo : ")
                }
                withStyle(
                    style = SpanStyle(
                        color = uiColor,
                        fontSize = 14.sp,
                        fontFamily = Roboto,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append(" Controlador")
                }
            }
        )
    }
}

@Composable
private fun TopSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black

    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.5f),
            painter = painterResource(id = R.drawable.shape),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Row(
            modifier = Modifier.padding(top = 80.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.logosplash),
                contentDescription = stringResource(id = R.string.app_logo),
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = stringResource(id = R.string.App_Comedores),
                style = MaterialTheme.typography.headlineMedium,
                color = uiColor
            )
        }

        Text(
            text = stringResource(id = R.string.Iniciar_Sesion),
            style = MaterialTheme.typography.headlineLarge,
            color = uiColor,
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(Alignment.BottomCenter)
        )
    }
}