//Why does the following not type-check?

trait List[+T] {
	def prepend(elem: T): List[T] = new Cons(elem, this)
}

// prepend fails variance checking


// Implement prepend as shown in trait List.
def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)


// What is the result type of this function:
def f(xs: List[NonEmpty], x: Empty) = xs prepend x


// ANSWER: List[IntSet]
