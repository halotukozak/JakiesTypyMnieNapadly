package halotukozak
package halotukozak.intro.types

object lambdas {

  trait Functor[A, +M[_]] {
    def map[B](f: A => B): M[B]
  }

  case class SeqFunctor[A](seq: Seq[A]) extends Functor[A, Seq] {
    def map[B](f: A => B): Seq[B] = seq.map(f)
  }

  val mappedSeq: Seq[Int] = SeqFunctor(Seq(1, 2, 3)).map(_ + 1)

  case class MapFunctor[K, V](mapKV: Map[K, V]) extends Functor[V, ({type L[a] = Map[K, a]})#L] {
    def map[V2](f: V => V2): Map[K, V2] = mapKV map { case (k, v) => (k, f(v)) }
  }

  val mappedMap: Map[Int, Int] = MapFunctor(Map(1 -> 1, 2 -> 2, 3 -> 3)).map(_ + 1)
}
