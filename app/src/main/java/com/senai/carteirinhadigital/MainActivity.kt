package com.senai.carteirinhadigital

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.zxing.qrcode.encoder.QRCode
import com.rafaelcosta.carteirinhadigital_4devm_t1.feature.carteirinha.presentation.component.QrCode
import com.senai.carteirinhadigital.ui.theme.CarteirinhaDigitalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarteirinhaDigitalTheme {
                Scaffold {
                    innerPadding ->
                    CarterinhaDigitalApp(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )

                }
            }
        }
    }
}

@Composable
fun CarterinhaDigitalApp(modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = 16.dp)
    ){
        Image(
            painter = painterResource(R.drawable.oioioi),
            contentDescription = null
        )

        Image(
            painter = painterResource(R.drawable.images),
            contentDescription = "Foto do Aluno",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)


        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Nome: ")
            Text(text = "Andrey Lima")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "curso: ")
            Text(text = "Desenvolvimento de Sistema")
        }

        QrCode("90000000001756605723")
    }
}

@Preview(showSystemUi = true)
@Composable
fun CarterinhaDigitalAppPreview() {
    CarteirinhaDigitalTheme {
        CarterinhaDigitalApp(
        )
    }
}
