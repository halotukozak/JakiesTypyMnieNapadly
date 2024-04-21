package halotukozak
package macros

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class TextTest extends Matchers:

  text[Normal]("HelloWorld") shouldBe "HelloWorld"
  text[Bold]("HelloWorld") shouldBe "**HelloWorld**"
  text[Bold & Italic]("HelloWorld") shouldBe "***HelloWorld***"
  text[Italic & Bold]("HelloWorld") shouldBe "***HelloWorld***"
  text[Strikethrough]("HelloWorld") shouldBe "~~HelloWorld~~"
  text[Code]("HelloWorld") shouldBe "`HelloWorld`"
  text[Code] {
    """
      |var a = 1
      |var b = 2
      |""".stripMargin
  } shouldBe {
    """```
      |
      |var a = 1
      |var b = 2
      |
      |```""".stripMargin
  }
  text[Bold]("Hello" + text[Italic]("World")) shouldBe "**Hello*World***"
  text[Strikethrough]("Hello" + text[InlineCode]("World")) shouldBe "~~Hello`World`~~"
  text[Bold](text[Bold](text[Bold]("Hello"))) shouldBe "******Hello******"

