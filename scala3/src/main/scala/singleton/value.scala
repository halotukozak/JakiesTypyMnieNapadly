package halotukozak
package singleton

object value {

  final val sth = "some string"
  val sthElse: sth.type = "some string"

  def identity(x: Any): x.type = x

  val id: 42 = identity(42)

  val a = "hello"
  val b = 42

  val result: Any =
    if (true) a else b


  def fun[T](t: T): T = t

  final val x = "hello"
  val y = fun(x)

}
