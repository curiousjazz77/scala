objet intsets {
println("Welcome to the scala worksheet")
  val t1 = new NonEmpty(3, new Empty, new Empty)    // t1: NonEmpty = {.3.}
  val t2 = t1 incl 4 // 4 gets added                // t2: IntSet = {.3{.4.}} invariant held
  
}

abstract class IntSet{
  def contains(x:Int): Boolean
  def incl(x:Int): IntSet
}

class Empty extends Intset {
  def contains(x:Int): Boolean = false
  def incl(x:Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  override def toString = "." // simple example
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
 }
