```scala
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
																																								
}

object rationals {

	val x = new Rational(3, 4)
	x.numer //3
	x.denom //4

	val y = new Rational(1, 3)
	val z = new Rational(5, 7)
	val a = new Rational(3, 2)
	y.numer
	y.denom
	y + z //  22/21
	y - z - a // -79/42
	y + y

	y < z
	y max z 

	y*y + z * a 
	// (we can still use other regular operators, * will take precendence)

	val strange = new Rational(1,0) // IllegalArgumentAssertion

	// assertion error
	val x = sqrt(y)
	assert(x >= 0)

	new Rational(2) // res = 2/1
}
```
