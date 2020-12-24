objet intsets {
println("Welcome to the scala worksheet")
}

abstract class IntSet{
  def contains(x:Int): Boolean
  def incl(x:Int): IntSet
}

class Empty extends Intset {
  def contains(x:Int): Boolean = false
  def incl(x:Int): IntSet = new NonEmpty(x, new Empty, new Empty)
 }
