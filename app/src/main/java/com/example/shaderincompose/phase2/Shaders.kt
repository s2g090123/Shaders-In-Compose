package com.example.shaderincompose.phase2

import android.graphics.RuntimeShader
import org.intellij.lang.annotations.Language

/**
 * `uniform` declares a global variable that can be set from outside
 * `layout(color)` indicates that this uniform is a color, so when setting its value from outside, you need to pass in a Color
 *   - see RuntimeShader#setColorUniform
 */
@Language("AGSL")
val GRADIENT_SHADER_EXEC = """
  layout(color) uniform half4 startColor;
  layout(color) uniform half4 endColor;
  uniform float width;
  
  half4 main(float2 fragCoord) {
    float horizontalFraction = fragCoord.x / width;
    return mix(startColor, endColor, horizontalFraction);
  }
""".trimIndent()

val GRADIENT_SHADER = RuntimeShader(GRADIENT_SHADER_EXEC)