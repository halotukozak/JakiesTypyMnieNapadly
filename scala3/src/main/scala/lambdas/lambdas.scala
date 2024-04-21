package halotukozak
package lambdas


val a: Int = 42
val b: String = "coffee"

class Film(title: String)

val c: Film = Film("Dune")

val d: List[Int] = List(1, 2, 3)

class Box[A](value: A)

val e: Box[List[Boolean]] = Box(List(true, false, true))


class Functor1[F[_]]

val fList = new Functor1[List]
val fOption = new Functor1[Option]

class Hell[F[_[_]]]

val hellFunctor = new Hell[Functor1]

type X = [T] =>> List[T]
type O = [L, R] =>> Either[L, R]
type A = [F[_]] =>> F[Int]

trait Functor[A, +M[_]]:
  def map[B](f: A => B): M[B]

case class MapFunctor[K, V](mapKV: Map[K, V]) extends Functor[V, [T] =>> Map[K, T]]:
  def map[V2](f: V => V2): Map[K, V2] = mapKV map { case (k, v) => (k, f(v)) }

val mappedMap: Map[Int, Int] = MapFunctor(Map(1 -> 1, 2 -> 2, 3 -> 3)).map(_ + 1)