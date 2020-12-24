    ~  scala                                                                                                          ✔  took 7s   at 14:36:10 
Welcome to Scala 2.13.3 
Type in expressions for evaluation. Or try :help.

scala> def square(x: Double) = x * x
def square(x: Double): Double

scala> square(2)
val res0: Double = 4.0

scala> square(5+4)
val res1: Double = 81.0

scala> square(square(4))
val res2: Double = 256.0

scala> def sumOfSquares(x:Double, y:Double) = square(x) + square(y)
def sumOfSquares(x: Double, y: Double): Double

scala> sumOfSquares(5, 4)
val res3: Double = 41.0

//_____Conditionals and Value Definitions


scala> def loop: Boolean = loop
                           ^
       warning: method loop does nothing other than call itself recursively
def loop: Boolean

scala> def anding(x: Boolean, y: =>Boolean): Boolean = { //would fail without y:Boolean being changed to y: => Boolean
     |     if (x) y else false
     | }
def anding(x: Boolean, y: => Boolean): Boolean

scala> anding(false, loop)
val res0: Boolean = false
