object intsets {
println("Welcome to the scala worksheet")
  val t1 = new NonEmpty(3, new Empty, new Empty)    // t1: NonEmpty = {.3.}
  val t2 = t1 incl 4 // 4 gets added                // t2: IntSet = {.3{.4.}} invariant held
  
}

//IntSet is called the superclass of Empty and NonEmpty
abstract class IntSet{
  def contains(x:Int): Boolean
  def incl(x:Int): IntSet
  
  /* 
  ** Exercise 
      Write a method `union` for forming the union of two sets
   */
  def union(other:Intset): Intset
}

// Empty and NonEmpty conform to type IntSet and can be used where it is
// They are subclasses of IntSet

//Base classes of NonEmpty are IntSet and Object
// The indirect or direct superclasses of a class are called base classes.
class Empty extends Intset {
  def contains(x:Int): Boolean = false
  def incl(x:Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  override def toString = "." // simple example
  def union(other: Intset): IntSet = other
 }


class NonEmpty(elem: Int, left: IntSet, right:IntSet) extends Intset {
  
  def contains(x:Int): Boolean = 
    if (x < elem) left contains x
    else if (x > elem) right contains x //recursive call
    else true
  
  //persistent data structure. this doesnt overwrite previous nodes, instead places on top of
  def incl(x:Int): IntSet = 
    if (x < elem) new NonEmpty(elem, left incl x, right) //keep going until find empty place to insert
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  
  override def toString = "{" + left + elem + right + "}"
  
  """
  And as a last action, let's include the element back into the set.
  So the new union has all the parts of the previous ones.
  It contains the left set. It contains the right set. It contains the element.
  And it contains the other set.
  So it's very easy to convince ourselves that indeed the result set here would have
  all the elements of the union. And would have no other elements.
  But that's another concern, and that is, well, how do we know that this recursion
  actually terminates? Because, after all, union calls union and we've seen already
  cases where calling yourself again would not terminate it.
  So the argument here we could make here is to say, well every call to union is
  actually on something that is smaller than the set we started with.
  First call to union was on the left sub-tree here.
  And obviously, that set is smaller than the whole non-empty set.
  The second call to union was on the union on left and right.
  And that again contains one element less than the full set that we have here.
  
  Because every call to union is on a set that is smaller, it follows that at some point
  we'll have to reach zero. And if the set is zero then we fall back to the case of empty
  sets where the union is immediate, we just returned the other set.
  So that's how we convince ourselves that the union that we operations that we do here are
  in fact terminating, and once those are terminating, we can safely add element back with
  an include operation as before. What object oriented languages do in this case,
  scala included is to use the dynamic method dispatch model. 
  
  That means that the code that's invoked by a method called depends on the runtime
  type of the object that contains the method. I believe that's best shown in an example.
  So let's say you have the code Empty contains 1. What do you do?
  """
  def union(other: Intset): IntSet =
    ((left union right) union other ) incl elem
 }
