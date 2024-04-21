package halotukozak.intersectionAndUnion

import halotukozak.{A, B}

val a: A | B = A()
val obj /*: Object*/ = if (???) A() else B()
val aOrB: A | B = if (???) A() else B()


transparent trait T

class T1 extends T

class T2 extends T

class YanushInput:
  def validate: Boolean = ???


class ScexSandbox:
  def validate: Boolean = ???

object Union {
  if true then new T1 else new T2

  Seq[YanushInput | ScexSandbox](new YanushInput, new ScexSandbox).forall {
    case x: YanushInput => x.validate
    case x: ScexSandbox => x.validate
  }
  Seq(new YanushInput, new ScexSandbox).forall {
    case x: YanushInput => x.validate
    case x: ScexSandbox => x.validate
  }
}

extension (x: YanushInput | ScexSandbox)
  def validate: Boolean = x match
    case x: YanushInput => x.validate
    case x: ScexSandbox => x.validate

object Union2 {
  Seq[YanushInput | ScexSandbox](new YanushInput, new ScexSandbox).forall(_.validate)
  Seq(new YanushInput, new ScexSandbox).forall(_.validate)
}