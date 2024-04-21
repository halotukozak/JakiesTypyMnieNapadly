package halotukozak
package macros

import scala.quoted.{Expr, Quotes, Type}

inline def helloWord: String = ${ helloWordImpl }
def helloWordImpl(using Quotes): Expr[String] = '{ "Hello World" }

inline def printUpperCase(str: String): Unit = ${ printUpperCaseImpl('{ str }) }
def printUpperCaseImpl(str: Expr[String])(using Quotes): Expr[Unit] = '{ println($str.toUpperCase) }

inline def unrolledPower(x: Double, n: Int): Double = ${ unrolledPowerImpl('{ x }, '{ n }) }
def unrolledPowerImpl(x: Expr[Double], n: Expr[Int])(using Quotes): Expr[Double] =
  n match
    case '{ 0 } => '{ 1.0 }
    case '{ 1 } => x
    case _ => '{ $x * ${ unrolledPowerImpl(x, '{ $n - 1 }) } }

type Normal
type Bold
type Italic
type Strikethrough
type InlineCode
type BlockCode
type Code = InlineCode | BlockCode

type TextStyle = Normal | Bold | Italic | Strikethrough | Code

inline def text[Style <: TextStyle](inline inner: String): String = ${ textImpl[Style]('{ inner }) }
private def textImpl[Style <: TextStyle : Type](inner: Expr[String])(using Quotes): Expr[String] = {
  Type.of[Style] match {
    case '[Normal] => inner
    case '[Bold & Italic] => '{ "***" + $inner + "***" }
    case '[Bold] => '{ "**" + $inner + "**" }
    case '[Italic] => '{ "*" + $inner + "*" }
    case '[Strikethrough] => '{ "~~" + $inner + "~~" }
    case '[InlineCode] => '{ "`" + $inner + "`" }
    case '[BlockCode] => '{ "```\n" + $inner + "\n```" }
    case '[Code] => '{
      if ($inner.split("\n").length == 1) "`" + $inner + "`"
      else "```\n" + $inner + "\n```"
    }
  }
}

