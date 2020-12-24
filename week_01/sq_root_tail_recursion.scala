import scala.annotation.tailrec

//worksheet
object session {
  1 + 3
  def abs(x: Double): Double = if (x < 0) -x else x

  @tailrec
  def sqrIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess else sqrIter(improve(guess, x), x)

//  def isGoodEnough(guess: Double, x: Double): Boolean = {
//    //not precise for smaller number (may be smaller than 0.01)
//    //no termination for small number (floating point numbers may be further apart than the epsilon value)
//    abs(guess * guess - x) < 0.01
//  }

  def isGoodEnough(guess: Double, x: Double): Boolean = {
    //not precise for smaller number (may be smaller than 0.01)
    //no termination for small number (floating point numbers may be further apart than the epsilon value)
    abs(guess * guess - x) / x < 0.01
  }

  def improve(guess: Double, x: Double): Double =
    (guess + x / guess) / 2


  def sqrt(x: Double): Double = sqrIter(1.0, x)

  sqrt(9)
  sqrt(4)
  sqrt(1e-6)
  sqrt(1e60) //non-termination
}
