import math.abs

object exercise {
		val tolerance = 0.0001
		
		def isCloseEnough(x:Double, y:Double) =
				abs((x-y) / x) / x < tolerance
		
		def fixedPoint(f: Double => Double)(firstGuess: Double) = {
				def iterate(guess: Double): Double = {
						val next = f(guess)
						if (isCloseEnough(guess, next)) next
						else iterate(next)
				}
				iterate(firstGuess)
		}
}

fixedPoint(x => 1 + x/2)(1) //result = 1.9999755859375

// return square root given what we know
/ sqrt(x) is a fixed point of the funcvtion (y => x / y)

def sqrt(x: Double) =  fixedPoint(y => ( y + x/y) / 2)(1)

// functions as return values
def averageDamp(f: Double => Double)(x:Double) = (x + f(x)) / 2


// write a sqrt function using fixedPoint and average damp

def sqrt(x: Double) = 
	fixedPoint(averageDamp(y => x/y))(1)
