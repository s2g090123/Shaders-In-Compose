package com.example.shaderincompose.phase3

import android.graphics.RuntimeShader
import org.intellij.lang.annotations.Language

@Language("AGSL")
val PIXELATE_SHADER_EXEC = """
  uniform shader texture;
  uniform float progress;
  uniform float blockSize;
  uniform float2 resolution;
  
  half4 main(float2 fragCoord) {
    float fraction = fragCoord.y / resolution.y;
    if (fraction > progress) {
      return texture.eval(fragCoord);
    }
    
    // Pixelation Calculation
    float2 textCoord = floor(fragCoord / blockSize) * blockSize;
    float2 textSize = 1.0 / resolution;
    return texture.eval(textCoord + textSize * 0.5);
  }
""".trimIndent()

val PIXELATE_SHADER = RuntimeShader(PIXELATE_SHADER_EXEC)