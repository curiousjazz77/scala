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

trait List[T]

//two subclasses Cons and Nil

// val does two things here: define the parameter of the class and field (value definition of the class)
// two fields head and tail become initialized (preferred as a syntax form since is precise)
class Cons[T](val head: Int, val tail: IntList) extends List[T]
class Nil[T] extends List[T]
