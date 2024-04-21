package halotukozak
package macros

import live_coding.HeadingLevel


inline def heading[N <: HeadingLevel : ValueOf](inline inner: String): String = "#" * valueOf[N] + inner

inline def f(p: Boolean) = if p then "true" else 0

val x: String | Int = f(true)

transparent inline def f2(p: Boolean) = if p then "true" else 0

val y: String = f2(true)
val z: Int = f2(false)

inline def f3(p: Boolean) = inline if p then "true" else 0
transparent inline def f4(o: String) = inline o match
  case "Kotlin" => "amazing"
  case "Scala" => 10d
  case _ => 0

//val b = f3(math.pow(3.0, 2.0) == 9.0)
val c: String = f4("Kotlin")
val d: Double = f4("Scala")
val e: Int = f4("Java")
