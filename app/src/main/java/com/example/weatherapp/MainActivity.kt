package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.WeatherAppTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BackgroundScreen()
                }
            }
        }
    }
}

@Composable
fun BackgroundScreen(){
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "WEATHER APP",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.padding(13.dp))
        BoxText()
        Spacer(modifier = Modifier.padding(13.dp))
        WeatherLocation()
        Spacer(modifier = Modifier.padding(13.dp))
        WeatherInfo()
        Spacer(modifier = Modifier.padding(13.dp))
    }
}
@Composable
fun BoxText(){
    Box(modifier = Modifier
        .clip(RoundedCornerShape(10.dp))
        .background(color = Color.Cyan)
        .fillMaxWidth(),
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            val img = painterResource(R.drawable.img_background)
            Image(painter = img, contentDescription = null,
                modifier = Modifier.size(150.dp) )
            Spacer(modifier = Modifier.padding(6.dp))
            Text(text = "Rain", color = Color.Black, fontSize = 40.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(13.dp))
        }
    }
}

@Composable
fun WeatherLocation(){
    Text(text = "19 C", fontSize = 64.sp, fontWeight = FontWeight.Bold)
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = R.drawable.baseline_location_on_24), contentDescription = null)
        Spacer(modifier = Modifier.padding(3.dp))
        Text(text = "Yogyakarta", fontWeight = FontWeight.Bold, fontSize = 40.sp)

    }
    Spacer(modifier = Modifier.padding(13.dp))
    Text(
        text = "Kasihan, Kabupaten Bantul, Daerah Istimewa Yogyakarta",
        textAlign = TextAlign.Center,
        fontSize = 20.sp,
        color = Color.Gray
    )
}
@Composable
fun WeatherInfo(){
    Box (modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(20.dp))
        .background(color = Color.Cyan)
        .height(200.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .fillMaxSize(), verticalArrangement = Arrangement.SpaceAround
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Humidity", fontSize = 20.sp)
                    Text(text = "98%", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "UV Index", fontSize = 20.sp)
                    Text(text = "9/10", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Sunrise", fontSize = 20.sp)
                    Text(text = "05.00 AM", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Sunset", fontSize = 20.sp)
                    Text(text = "05.40 PM", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                }
            }
        }
    }
}
//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherAppTheme {
        BackgroundScreen()
    }
}