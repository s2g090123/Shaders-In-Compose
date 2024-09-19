package com.example.shaderincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.RepeatMode.Reverse
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.toSize
import com.example.shaderincompose.ui.theme.ShaderInComposeTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      ShaderInComposeTheme {
        var size by remember { mutableStateOf(Size(0f, 0f)) }

        val transition = rememberInfiniteTransition(label = "progress_transition")
        val progress by transition.animateFloat(
          initialValue = 0f,
          targetValue = 1f,
          animationSpec = infiniteRepeatable(
            animation = keyframes {
              durationMillis = 5000
            },
            repeatMode = Reverse,
          ),
          label = "progress",
        )

        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Box(
            modifier = Modifier
              .fillMaxSize()
              .padding(innerPadding),
            contentAlignment = Alignment.Center,
          ) {
            Image(
              modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.3f)
                .onSizeChanged { size = it.toSize() }
                .graphicsLayer {
                  renderEffect = BlurEffect(
                    radiusX = (size.width / 2f * progress).coerceAtLeast(0.0001f),
                    radiusY = (size.height / 2f * progress).coerceAtLeast(0.0001f),
                    edgeTreatment = TileMode.Decal,
                  )
                },
              painter = painterResource(R.drawable.cat),
              contentDescription = null,
              contentScale = ContentScale.Crop,
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