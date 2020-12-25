package week4

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}


class Cons[T](val head: Int, val tail: IntList) extends List[T] {
  def isEmpty: Boolean = false //cons cells are never empty
  
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw NoSuchElementException("Nil.head")
  def tail: Nothing = throw NoSuchElementException("Nil.tail")
}

object List {
	// List(1, 2) = List.apply(1, 2)
	def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
	def apply[T]() = new Nil
}
