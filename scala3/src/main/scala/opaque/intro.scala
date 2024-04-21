package halotukozak
package opaque

import opaque.Definitions.Alias

object Definitions:
  opaque type Alias = String

object Usage:
  val a: Alias = "a"
  val b: String = a
