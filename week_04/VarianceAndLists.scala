package week4

/*
- lets go back to previous implementation of lists
- One shortcoming was that Nil had to be a class, whereas we would prefer it be an objects (after all, there is only one empty list)
- Can we change that? Yes, because we can make List covariant
*/

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: Int, val tail: IntList) extends List[T] {
  def isEmpty: Boolean = false //cons cells are never empty
  
}

//nothing is a bottom type that is universal and can be used to express everything else .
object Nil[T] extends List[Nothing] {
  def isEmpty: Boolean = true
  def head: Nothing = throw NoSuchElementException("Nil.head")
  def tail: Nothing = throw NoSuchElementException("Nil.tail")
}

object test {
	val x: List[String] = Nil
}
