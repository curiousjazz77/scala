// Rationals are kept unsimplified until turned into strings

class Rational(x: Int, y:Int) {
	require( y != 0, "denominator must be nonzero")

	
	// second constructor that implictly uses the primary constructor
	def this(x:Int) = this(x, 1)

	private def gcd(a:Int, b:Int): Int = if (b==0) a else gcd(b, a % b)
	
	def numer = x 
	def denom = y 

	override def toString = {
		private val g = gcd(numer, denom)
		numer/g + "/" + denom/g

	def less(that: Rational) = numer * that.denom < that.numer * denom

	def max(that: Rational) = if this.less(that) that else this

	def add(that: Rational) =
		new Rational(
			numer * that.denom + that.number * denom,
			denom * that.denom
		)

	def neg(that: Rational) = new Rational(-numer , denom)

	def sub(that: Rational) = add(that.neg)	
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
	y.add(z) //  22/21
	y.sub(z).sub(a). // -79/42
	y.add(y)

	y.less(z)
	y.max(z) 

	val strange = new Rational(1,0) // IllegalArgumentAssertion

	// assertion error
	val x = sqrt(y)
	assert(x >= 0)

	new Rational(2) // res = 2/1
}
