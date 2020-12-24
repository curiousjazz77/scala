/*
In the IntSet example, one may argue that there is really only a single empty IntSet. 
So it seems overkill to have the user create many instances of it. 
We can express this case better with an object definition

This defines a singleton object named Empty
No other Empty instances can be (or need to be) created
Singleton objects are values, so Empty evaluates to itself
*/

object intsets {
println("Welcome to the scala worksheet")
  val t1 = new NonEmpty(3, new Empty, new Empty)    // t1: NonEmpty = {.3.}
  val t2 = t1 incl 4 // 4 gets added                // t2: IntSet = {.3{.4.}} invariant held
  
}

abstract class IntSet{
  def contains(x:Int): Boolean
  def incl(x:Int): IntSet
}

//instead of keyword class, use object
object Empty extends Intset {
  def contains(x:Int): Boolean = false
  
  // you simply name the class so `Empty` replaces `new Empty` that we had before
  // singleton objects are already a value, so no additional evaluation is performed
  def incl(x:Int): IntSet = new NonEmpty(x, Empty, Empty)
  override def toString = "." // simple example
 }
