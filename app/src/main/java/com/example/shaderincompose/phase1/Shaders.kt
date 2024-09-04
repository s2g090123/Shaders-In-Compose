package com.example.shaderincompose.phase1

import android.graphics.RuntimeShader
import org.intellij.lang.annotations.Language

/**
 * Return the color at a specified position
 *
 * - `@Language("AGSL")` is an annotation indicating that the specified string is written in AGSL
 * - `half` is a 16-bit floating type, and `half4` is a vector composed of four half
 * - `half4` is typically used to represent coordinates (x, y, z, w) and colors (r, g, b, a)
 * - `fragCoord` represents the current position being rendered
 */
@Language("AGSL")
val COLOR_SHADER_EXEC = """
  half4 main(float2 fragCoord) {
  return half4(1.0, 0.0, 0.0, 1.0);
}
""".trimIndent()

val COLOR_SHADER = RuntimeShader(COLOR_SHADER_EXEC)
