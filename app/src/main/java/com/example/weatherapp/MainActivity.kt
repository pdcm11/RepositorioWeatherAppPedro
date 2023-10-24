package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.theme.WeatherAPPTheme

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
                    HomeScreen()
                }
            }
        }
    }
}
@Preview(showBackground = true, widthDp = 390, heightDp = 800)
@Composable
fun HomeScreen(){
    Column {
        HeaderComponent()
        WelcomeMessageComponent()
        ImagePreviewComponent()
        SevenDaysForecastComponent()
    }
}

@Preview(showBackground = true, widthDp = 390)
@Composable
fun HeaderComponent(): Unit {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically)
    {
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = Color.White))
            {
                Image(
                    painter = painterResource(id = R.drawable.lupa),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                )
        }
    }

}

@Composable
fun WelcomeMessageComponent(): Unit {

}

@Composable
fun ImagePreviewComponent(): Unit {
    Row {
        Text(text = "ImagePreview")
    }
}

@Composable
fun SevenDaysForecastComponent(): Unit {

}