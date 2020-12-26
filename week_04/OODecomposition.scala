/*
      Expr
      / \
Number   Sum

Problem: Writing all these classification and accessor functions quickly
   becomes redious
*/
trait Expr {
	def isNumber: Boolean
	def isSSum: Boolean
	def numValue: Int
	def leftOp: Expr
	def rightOp: Expr
}

class Number(n: Int) extends Expr {
	def isNumber: Boolean = false
	def isSSum: Boolean = true
	def numValue: Int = n
	def leftOp: Expr = throw new Error("Number.leftOp")
	def rightOp: Expr = throw new Error("Number.rightOp")
}

class Sum(e1: Expr, e2: Expr) extends Expr {
	def isNumber: Boolean = false
	def isSSum: Boolean = true
	def numValue: Int = throw new Error("Sum.numValue")
	def leftOp: Expr = e1
	def rightOp: Expr = e2
}
def eval(e: Expr): Int {
	if (e.isNUmber) e.numValue
	else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
	else throw new Error("Unknown expression " + e)
}


// potential solution
trait Expr {
	def eval: Int
}

class Number(n: Int) extends Expr {
	def eval: Int = n
}

class Sum(e1: Expr, e2: Expr) extends Expr {
	def eval: Int = e1.val + e2.eval
}

/*
But what happens if you want to display expression now? def show()
You have to define new methods in all subclasses now - DISADVANTAGE
touching too many pieces of code could be too pervasive

- Limitations of OO Decomposition
    - And what if you want to simplify the expresisons, day using the rule
        - `a * b + a * c -> a * (b + c)`
            - Problem:
                - This is a non-local simnplification. It can't be encapsulated in the method of a single object
                - You are back to swuare onel you need test and access methods for all the different subclasses.
*/
