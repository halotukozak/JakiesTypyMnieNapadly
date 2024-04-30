package halotukozak
package typelevel

def nums = 1 :: 2 :: 3 :: 4 :: Nil
def map[A, B](ls: List[A], f: A => B): List[B] =
  ls match
    case Nil => Nil
    case h :: t => f(h) :: map(t, f)
def mapped = nums.map(i => i + 10)
def filtered = mapped.filter(i => i < 14)
def result = fold(filtered, "", (i, acc) => toString(i) ++ acc)

import scala.Tuple.{Map as _, *}
import scala.compiletime.ops.any.ToString
import scala.compiletime.ops.int.*

type Nums = 1 *: 2 *: 3 *: 4 *: EmptyTuple
type Map[T <: Tuple, F[_]] <: Tuple =
  T match
    case EmptyTuple => EmptyTuple
    case h *: t => F[h] *: Map[t, F]
type Mapped = Nums `Map` ([X] =>> X + 10)
type Filtered = Mapped `Filter` ([X] =>> X < 14)
type Result = Fold[Filtered, "", [I, Acc] =>> ToString[I] + Acc]