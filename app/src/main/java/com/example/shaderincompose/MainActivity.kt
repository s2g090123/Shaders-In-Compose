package com.example.shaderincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.tooling.preview.Preview
import com.example.shaderincompose.phase1.COLOR_SHADER
import com.example.shaderincompose.ui.theme.ShaderInComposeTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      ShaderInComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Canvas(
            modifier = Modifier
              .fillMaxSize()
              .padding(innerPadding)
          ) {
            drawRect(
              brush = ShaderBrush(COLOR_SHADER) // // Create a brush using RuntimeShader
            )
          }
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  ShaderInComposeTheme {
    Greeting("Android")
  }
}