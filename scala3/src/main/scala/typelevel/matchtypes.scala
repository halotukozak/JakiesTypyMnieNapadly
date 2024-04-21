package halotukozak
package typelevel


def fold(ints: List[Int], str: String, function: (Nothing, Nothing) => String) = ???

def nums = 1 :: 2 :: 3 :: 4 :: Nil
def map[A, B](ls: List[A], f: A => B): List[B] =
  ls match
    case Nil => Nil
    case h :: t => f(h) :: map(t, f)
def mapped = nums.map(i => i + 10)
def filtered = mapped.filter(i => i < 14)
def result = fold(filtered, "", (i, acc) => toString(i) ++ acc)