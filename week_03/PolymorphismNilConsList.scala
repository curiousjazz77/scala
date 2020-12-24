/*
Nil -  the empty list

Cons - A cell containing an element and the remainder of the list.

So cons list is an immutable link list constructed from two building blocks.
The empty list which we call mill and the cell that contains first element of the list
and a pointer reference to the rest of the list,
that is called cons

List(1, 2, 3)
List(List(true, false), List(3))

A list is either:
  - an empty list new Nil, or 
  - a list new Cons(x, xs) consisting of a head elelement x and a tail list xs
*/

package week3

trait IntList...

//two subclasses Cons and Nil

// val does two things here: define the parameter of the class and field (value definition of the class)
// two fields head and tail become initialized (preferred as a syntax form since is precise)
class Cons(val head: Int, val tail: IntList) extends IntList
class Nil extends IntList


//Since it's too narrow to define lists with Int element, we will generalize using a type parameter
package week3

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

//two subclasses Cons and Nil

// val does two things here: define the parameter of the class and field (value definition of the class)
// two fields head and tail become initialized (preferred as a syntax form since is precise)
class Cons[T](val head: Int, val tail: IntList) extends List[T] {
  def isEmpty: Boolean = false //cons cells are never empty
  
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw NoSuchElementException("Nil.head")
  def tail: Nothing = throw NoSuchElementException("Nil.tail")
}

/*
Like classes, functions can have type parameters

For instance, here is a function that creates a list consisting of a single element

def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

We can then write:

singleton[Int](1)
singleton[Boolean](true)

