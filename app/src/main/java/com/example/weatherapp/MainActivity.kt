package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.theme.WeatherAPPTheme
import com.example.weatherapp.ui.theme.temperaturaDia
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAPPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPage()
                }
            }
        }
    }
}

var informacaoSeteDias = listOf(
    temperaturaDia(
        temperatura = 16,
        estado = "Limpo",
        resource = R.drawable.sun
    ),
    temperaturaDia(
        temperatura = 13,
        estado = "Nublado",
        resource = R.drawable.cloudy
    ),
    temperaturaDia(
        temperatura = 10,
        estado = "Chuva",
        resource = R.drawable.rainy
    ),
    temperaturaDia(
        temperatura = 2,
        estado = "Neve",
        resource = R.drawable.snowy
    ),
    temperaturaDia(
        temperatura = 6,
        estado = "Tempestade",
        resource = R.drawable.storm
    ),
    temperaturaDia(
        temperatura = 5,
        estado = "Tempestade",
        resource = R.drawable.storm
    ),
    temperaturaDia(
        temperatura = 4,
        estado = "Tempestade",
        resource = R.drawable.storm
    ),
)

@Preview(showBackground = true, widthDp = 390)
@Composable
fun HeaderComponent(): Unit {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp, 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .size(40.dp),
            contentPadding = PaddingValues()

        )

        {
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Lupa",
            )
        }

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(),
            modifier = Modifier
                .clip(CircleShape)
                .width(40.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.foto),
                contentDescription = "Foto"
            )

        }
    }

}

@Preview(showBackground = true, widthDp = 390, heightDp = 65)
@Composable
fun Info(name: String = "Pedro"): Unit {
    Column(modifier = Modifier.fillMaxWidth()) {

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Olá",
                modifier = Modifier.padding(end = 2.dp),
                color = Color.DarkGray
            )

            Text(
                text = "$name",
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = formatData(Calendar.getInstance().time),
                color = Color.DarkGray
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Alverca do Ribatejo",
                color = Color.DarkGray
            )

        }

    }
}

fun formatData(data: Date): String {
    val format = SimpleDateFormat("dd MMM, EEE yyyy", Locale("pt", "PT"))
    return format.format(data)

}

@Preview(showBackground = true, widthDp = 380, heightDp = 800)
@Composable
fun MainPage(): Unit {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        HeaderComponent()
        Info("Pedro")
        ImagemCentral()
        ProximosSeteDias()
    }
}

@OptIn(ExperimentalUnitApi::class)
@Preview(showBackground = true, widthDp = 380, heightDp = 300)
@Composable
fun ImagemCentral(): Unit {
    Box(
        modifier = Modifier
            .height(300.dp)
            .background(Color.Transparent)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.LightGray)
                .size(290.dp)
        ) {


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sun),
                    contentDescription = "sol"
                )
            }

            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 180.dp, 0.dp, 0.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "12ºC",
                    fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(55f, TextUnitType.Sp),
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Limpo",
                    fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(15f, TextUnitType.Sp),
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 350, widthDp = 380)
@Composable
fun ProximosSeteDias(): Unit {
    LazyRow(){
        items(informacaoSeteDias){
            ProximoDia(temperaturaDia = it)
        }
    }
}

@Composable
fun ProximoDia(temperaturaDia: temperaturaDia): Unit{

    Column (
        modifier = Modifier
            .width(100.dp)
            .padding(15.dp, 15.dp, 15.dp, 15.dp)
    ){
        Image(painter = painterResource(id = temperaturaDia.resource), contentDescription = temperaturaDia.estado)
        Text(text = temperaturaDia.temperatura.toString())
        Text(text = temperaturaDia.estado)
    }

}



