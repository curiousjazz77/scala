import scala.annotation.tailrec

//worksheet
object session {
  1 + 3
  def abs(x: Double): Double = if (x < 0) -x else x

  def sqrt(x: Double): Double = {
    // reformatted to have sqrt contain the functions
    // only sqrt is seen from outside
    // block: deliminated by braces was used
    @tailrec
    def sqrIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess else sqrIter(improve(guess))

    def isGoodEnough(guess: Double): Boolean = {
      //not precise for smaller number (may be smaller than 0.01)
      //no termination for small number (floating point numbers may be further apart than the epsilon value)
      // x only passed in once
      abs(guess * guess - x) / x < 0.01
    }

    def improve(guess: Double): Double =
      (guess + x / guess) / 2

    sqrIter(1.0)
  }

  sqrt(9)
  sqrt(4)
  sqrt(1e-6)
  sqrt(1e60) //non-termination
}
