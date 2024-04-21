package halotukozak
package opaque

import opaque.Definition.Complex

object Definition:
  opaque type Complex <: (Double, Double) = (Double, Double)

  object Complex:
    def apply(real: Double, imag: Double): Complex = (real, imag)

  extension (c: Complex)
    def +(that: Complex): Complex = (c._1 + that._1, c._2 + that._2)

object impl:
  val a = Complex(1, 2)
  val b = Complex(3, 4)
  val sum = a + b

  val real: Double = a._1
  val imag: Double = a._2
  val sum2 = a + (3, 4)


