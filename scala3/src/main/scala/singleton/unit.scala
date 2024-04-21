package halotukozak
package singleton


object Unit {
  val a: Unit = ()
  println() == () //always true
}

object someObject:
  val ref: someObject.type = someObject

class Parent:
  object Child

  def f(another: Parent): Child.type = another.Child