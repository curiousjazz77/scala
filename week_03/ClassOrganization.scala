package week 3 
/*
Classes and objects are organized in packages (same as Java)
*/


// Swap out named functions for operators

class Rational(x: Int, y:Int) {
	require( y != 0, "denominator must be nonzero")

	def this(x:Int) = this(x, 1)

	private def gcd(a:Int, b:Int): Int = if (b==0) a else gcd(b, a % b)
	
	def numer = x 
	def denom = y 

	override def toString = {
		private val g = gcd(numer, denom)
		numer/g + "/" + denom/g
	}

	def <(that: Rational) = numer * that.denom < that.numer * denom

	def max(that: Rational) = if this < that that else this

	def + (that: Rational) =
		new Rational(
			numer * that.denom + that.number * denom,
			denom * that.denom
		)

  //space must be between the - and : to avoid making a new operation
	def unary_- : Rational) = new Rational(-numer , denom)

	def - (that: Rational) = this + -that
}



// in separate worksheet
import week3._ //imports everything, but sometimes less legible. (wildcard import)
//import week3.Rational           (named import)
//import week3.{Rational, Hello}  (named import)

object scratch {
  new week3.Rational(1,2)
}
