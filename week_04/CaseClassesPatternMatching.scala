

trait Expr
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr

// it implicitly defines companion objects with apply methods
object Number {
	def apply(n: Int) = new Number(n)
}
object Sum { 
	def apply(e1: Expr, e2: Expr) = new Sum(e1, e2)
}

// so you can write Number(1) instead of new Number(1)
// However, these classes are now empty. So how can we access the members?
// That's what we need PATTERN MATCHING for

def eval(e: Expr): Int = e match {
	case Number(n) => n
	case Sum(e1, e2) => eval(e1) + eval(e2)
}

/*
eval(Sum(Number(1), Number(2)))

-> 

Sum(Number(1), Number(2)) match { 
	case Number(n) => n
	case Sum(e1, e2) => eval(e1) + eval(e2)
}
-> 

eval(Number(1)) + eval(Number(2))

-> 

(Number(1) match { 
	case Number(n) => n
	case Sum(e1, e2) => eval(e1) + eval(e2)
}

-> 
1 + eval(Number(2))

-> 
3
*/

// optional exercise to add Var and Prod - might not be right
trait Expr {
	def eval(e: Expr): Int = e match {
		case Number(n) => n
		case Sum(e1, e2) => eval(e1) + eval(e2)
	}

	def show(e: Expr: String = e match {
		case Number(n) => n.toString
		case Var(v) => v
		case Sum(e1, e2) => show(e1) + " + " show(e2)
		case Prod(e1, e2) => e1 match {
				case Sum(x1, x2) => "(" + show(x1) + " * " show(x2) +") " + show(e2)
				case Number(nu) => show(nu) + " * " show(e2)
				case Var(vu) => show(nu) + " * " show(e2)
	}
}
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Var(n: String) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr


//sorting lists
def isort(xs: List[Int]): List[Int] = xs match {
	case List() => List()
	case y :: ys => insert(y, isort(ys))
} 
def insert(x: Int, xs: List[Int]): List[Int] = xs match {
	case List() => List(x)
	case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
}

