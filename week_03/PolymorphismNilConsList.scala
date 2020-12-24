/*
POLYMORPHISM: a function type that comes "in many forms"
  - the function can be applied to arguments of many types, or
  - the type can have instances of many types
  
Two principle forms of polymorphism:
  - subtyping: instances of a subclass can be passed to a base class
    - List has 2 subtypes: Nil and Cons
    - wherever you have a parameter that uses a list, you can use Nils or Cons
  - generics: instances of a function or class are created by type parametrization
    - can create a list of ints, doubles, etc with generic typing

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


Type parameters in scala don't affect evaluation in Scala
We can assume that all type parameneters and type arguments are removed before 
evaluating the program: THIS IS CALLED: TYPE ERASURE


  Exercise:
  Given our definition of lists, write a function nth that takes an integer n and the list
  and selects the nth element of the list. So we assume that elements in the list are
  numbered from zero. So the first element in the list has index zero, the second has
  index one, and so on. The other specification is that if an index is outside the range
  from zero up to the length of the list minus one, so it's outside range, then you should
  throw an index out of bounds exception.
  So let's see how we would solve the exercise.
  
*/

import week3._
object nth {
   def nth[T](n: Int, xs: List[T]): T =
      if (xs.isEmpty) throw new IndexOutOfBoundsException
      if (n == 0) xs.head
      else nth(n - 1, xs.tail)
  
  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
  
  nth(2, list) //res0: Int = 3
  
  // what if index is not part of the list to get out of bounds exception
  nth(4, list)
  nth(-1, list)
}
