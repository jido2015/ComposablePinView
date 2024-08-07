package com.olajide.composablepinvie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.olajide.composablepinvie.ui.theme.ComposablePinVieTheme
import com.olajide.pinviewscreen.ui.presentation.ComposablePinView

class MainActivity : ComponentActivity() {
    private val charLimit = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposablePinVieTheme {
                val pin = remember{ mutableStateOf("") }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    ComposablePinView(
                        textStyle = TextStyle(fontSize = 20.sp),
                        charLimit = charLimit, value = pin)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposablePinVieTheme {
        Greeting("Android")
    }
}