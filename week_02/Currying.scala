//re-write; only take single parameter f
//sumF takes the usual bounds within

def sum(f: Int => Int)(Int, Int): Int = {
	def sumF(a: Int, b: Int): Int = {
			if(a > b) 0
			else f(a) sumF(a+1, b)
  sumF
  }
 
/*
As a result we can define the functions as follows
Either giving an anonymous function or a named function
*/

def sumInts       = sum(x => x)
def sumCubes      = sum(x => x * x * x)
def sumFactorials = sum(fact)

sumCubes(1, 10) * sumFactorials(10, 20)

/*
Consecutive stepwise applications

In the previous example, can we avoid the sumInts, sumCubes, ... middlemen? 

Yes 
*/

sum (cube)(1, 10)
/* sum(ube) applies sum to the cube function
the function is next aplpies to the arguments(1, 10)
associative from the left
*/


// Multiple parameter lists

def sum(f: Int => Int)(a: Int, b:Int): Int = 
  if (a>b) 0 else f(a) + sum(f)(a+1, b)


sum(cube) //valid on its own and can be used later


// Currying exercises
/*
Write a product function that calculates the product of
 the values of a function for the points on a given interval
*/
def product(f: Int => Int)(a:Int, b:Int): Int = {
			if(a > b) 1
			else f(a) * product(f)(a+1, b)
}
product(x=> x * x)(3, 4) //144; 9 * 16
product(x=> x )(3, 4) //12; 3 * 4


/*
Write factorial in terms of product
*/
def fact(n: Int): Int = product(x => x) (1, n)
fact(5) // 120



/*
Can you write a more general function that
generalizes both sum and product?
*/

def mapReduct(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a:Int, b:Int): Int = 
	if (a>b) zero
	else combine(f(a), mapReduce(f, combine, zero)(a+1, b))

//must be below mapReduce to avoid a forward reference
def product(f: Int => Int)(a:Int, b:Int): Int = mapReduce(f, (x,y) => x * y, 1)(a, b)
