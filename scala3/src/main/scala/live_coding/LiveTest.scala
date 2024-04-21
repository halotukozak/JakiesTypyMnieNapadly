package halotukozak
package live_coding

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class LiveTest extends Matchers:

  heading[1]("Hello") shouldBe "#Hello"
  heading[2]("Hello") shouldBe "##Hello"
  heading[3]("Hello") shouldBe "###Hello"
  heading[4]("Hello") shouldBe "####Hello"
  heading[5]("Hello") shouldBe "#####Hello"
  heading[6]("Hello") shouldBe "######Hello"
  
  
  assertDoesNotCompile("""heading[7]("Hello")""")
  assertDoesNotCompile("""heading[0]("Hello")""")
  assertDoesNotCompile("""heading[-5]("Hello")""")
  
  
  assert(link(title = "you MUST see", url = "https://www.avsystem.com") == "[you MUST see](https://www.avsystem.com)")
  
  assertDoesNotCompile("""link(title = "you SHOULD see", url = "https://www.avsystem.com")""")
  assertDoesNotCompile("""link(title = "have to you see", url = "https://www.avsystem.com")""")
