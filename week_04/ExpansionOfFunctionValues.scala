// An anonymous function such as 
(x: Int) => x * x

is expanded to:

{ class AnonFun extends Function1[Int, Int] {
	def apply(x:Int) = x * x
	}
	new AnonFun
}
