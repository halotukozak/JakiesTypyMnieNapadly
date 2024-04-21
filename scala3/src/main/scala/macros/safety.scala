package halotukozak
package macros


import scala.quoted.*

inline def debug(expr: => Any): Unit = ${ debugImpl('{ expr }) }

def debugImpl(expr: Expr[Any])(using qctx: Quotes): Expr[Unit] = {
  val code: String = expr.show
  '{
    println(s"Debugging: $code")
  }
}

inline def isEven(inline n: Int): Boolean = ${ isEvenImpl('{ n }) }

def isEvenImpl(n: Expr[String])(using Quotes): Expr[Int] = {
  val result = '{ 2 == 0 }
  result
}

def evalAndUse[T: Type](x: Expr[T])(using Quotes) = '{
  val x2: T = $x
  ???
}

