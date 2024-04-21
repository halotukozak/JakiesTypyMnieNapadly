package halotukozak
package halotukozak.intersectionAndUnion


class YanushInput {
  def validate: Boolean = true
}

class ScexSandbox {
  def validate: Boolean = true
}


trait HasValidation {
  def validate: Boolean
}

object Union {
  implicit class YanushInputOps(yanushInput: YanushInput) extends HasValidation {
    def validate: Boolean = yanushInput.validate
  }

  implicit class ScexSandboxOps(scexSandbox: ScexSandbox) extends HasValidation {
    def validate: Boolean = scexSandbox.validate
  }

  Seq[HasValidation](new YanushInput, new ScexSandbox).map(_.validate)
  Seq(new YanushInput, new ScexSandbox).forall {
    case x: YanushInput => x.validate
    case x: ScexSandbox => x.validate
  }
}

