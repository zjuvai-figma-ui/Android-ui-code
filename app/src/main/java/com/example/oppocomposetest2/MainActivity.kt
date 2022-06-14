package com.example.oppocomposetest2

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.oppocomposetest2.ui.theme.OppoComposeTest2Theme
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContent {
            OppoComposeTest2Theme {
                val systemUiController: SystemUiController = rememberSystemUiController()
                // systemUiController.isStatusBarVisible = false // Status bar
                systemUiController.isNavigationBarVisible = false // Navigation bar
                //systemUiController.isSystemBarsVisible = false // Status & Navigation bars
                rememberSystemUiController().setStatusBarColor(
                    Color.Transparent, darkIcons = MaterialTheme.colors.isLight)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    page1Layout();
                }
            }
        }
    }
}

@Composable
fun page1Layout() {
    Column{
        title()
            Row ( modifier = Modifier
                .background(Color(0xffe5e5e5))
                .padding(16.dp, 20.dp)
                .height(105.dp)
                .width(375.dp)
            ){
                Button(onClick = {  },
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(2.dp, Color(0xff000000)),
                    modifier = Modifier
                        .width(167.dp)
                        .height(52.dp),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 0.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xffffffff),
                        contentColor = Color(0xff000000)
                    )) {
                    Text(text = "LOG IN",
                        fontWeight = FontWeight(900),
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.roboto)))
                }
                Spacer(modifier = Modifier.width(9.dp)
                )
                Button(onClick = {  },
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(2.dp, Color(0xff000000)),
                    modifier = Modifier
                        .width(167.dp)
                        .height(52.dp),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 0.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xff000000),
                        contentColor = Color(0xffffffff)
                    )) {
                    Text(text = "REGISTRY",
                        fontWeight = FontWeight(900),
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.roboto))
                    )
                }
            }

    }
}

@Composable
fun title() {
    Box() {
        Image(
            painter = painterResource(R.drawable.page1_bg),
            contentDescription = "Background picture",
            modifier = Modifier
                .width(375.dp)
                .height(707.dp),
        )
        Column(modifier = Modifier.padding(start = 84.dp,top=312.dp)){
            Image(
                painter = painterResource(R.drawable.photo),
                contentDescription = "Title Icon",
                modifier = Modifier
                    .width(38.dp)
                    .height(38.dp)
            )
        }
        Column(modifier = Modifier.padding(start = 142.dp,top=307.dp)){
            Text(text = "photo",
                fontSize = 48.sp,
                fontFamily = FontFamily(Font(R.font.comfortaa_r))
            )
        }
        Row(modifier = Modifier.padding(start=16.dp,top=659.dp)){
            Image(
                painter = painterResource(R.drawable.ellipse),
                contentDescription = "Profile picture",
                modifier = Modifier
                    .width(28.dp)
                    .height(28.dp),
            )
            Column(modifier = Modifier.padding(start=8.dp)) {
                Text(text = "Pawel Czerwinski",
                    fontWeight = FontWeight(700),
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    modifier = Modifier
                        .height(15.dp));
                Text(text = "@pawel_czerwinski",
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    modifier = Modifier
                        .height(13.dp))
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OppoComposeTest2Theme {
        page1Layout();
    }
}