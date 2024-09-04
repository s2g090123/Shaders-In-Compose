package com.example.shaderincompose.phase1

import android.graphics.RuntimeShader
import org.intellij.lang.annotations.Language

@Language("AGSL")
val COLOR_SHADER_EXEC = """
  half4 main(float2 fragCoord) {
  return half4(1.0, 0.0, 0.0, 1.0);
}
""".trimIndent()

val COLOR_SHADER = RuntimeShader(COLOR_SHADER_EXEC)
