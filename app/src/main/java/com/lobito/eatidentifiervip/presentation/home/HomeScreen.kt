package com.lobito.eatidentifiervip.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.lobito.eatidentifiervip.R
import com.lobito.eatidentifiervip.presentation.widget.CustomTextField
import com.lobito.eatidentifiervip.presentation.widget.ToastyMessages
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    onNavigate: (String) -> Unit,
) {
    val viewModel: HomeViewModel = koinViewModel()
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        MainPrinterFaster(viewModel)
    }
}

@Composable
fun MainPrinterFaster(viewModel: HomeViewModel){
    var scannedText by remember { mutableStateOf("") }
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.DarkGray

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .zIndex(1f)
            .padding(horizontal = 10.dp)
            .background(
                Color(0xFFEFEEEE),
                shape = RoundedCornerShape(40.dp)
            )
            .clip(RoundedCornerShape(40.dp))
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 20.dp),
            textAlign = TextAlign.Center,
            text = "ESCANEE SU DNI O IDENTIFICADOR",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold // Ajusta el grosor del texto
            ),
            color = Color.DarkGray
        )
        Image(
            painter = painterResource(id = R.drawable.qr_icon),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.CenterHorizontally)
                .zIndex(1f) // Asegura que la imagen esté encima
        )
        Spacer(modifier = Modifier.height(25.dp))
        CustomTextField(
            value = scannedText,
            onValueChange = { newText -> scannedText = newText },
            label = "DNI O IDENTIFICADOR",
            uiColor = uiColor,
            actionTextField ={ viewModel.findClient(scannedText)}
        )
        Spacer(modifier = Modifier.height(100.dp))
    }

}
