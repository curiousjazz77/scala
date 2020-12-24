object higherOrderFunctions{

// Regular way

/*
Sum of integers between a and b
*/
def sumInts(a: Int, b:Int): Int = 
  if (a>b) 0 else a + sumInts(a+1, b)

//Sum of all the cubes between a and b
def cube(x:Int): Int = x * x * x

def sumCubes(a: Int, b:Int): Int = 
	if (a>b) 0 else cube(a) + sumCubes(a+1, b)

// Sum of the factorials of integers between a anf b
def fact(x: Int): Int = if (x==0) 1 else fact(x-1)

def sumFactorials(a: Int, b:Int): Int = 
	if (a>b) 0 else fact(a) + sumFactorials(a+1, b)
  
/ summing with higher order functions

def sum(f: Int => Int, a: Int, b: Int): Int = 
	if (a>b) 0 else f(a) + sum(f, a+1, b)

//We can then write
def sumInts(a: Int, b:Int)       = sum(id, a, b)
def sumCubes(a: Int, b:Int)      = sum(cube, a, b)
def sumFactorials(a: Int, b:Int) = sum(fact, a, b)

// where

def id(x: Int): Int   = x
def cube(x: Int): Int = x * x * x
def fact(x: Int): Int = if (x==0) 1 else fact(x-1)


// anonymous functions: introducing literals as functions

(x:Int) => x * X * x

(x:Int, y:Int) => x + y


/*
Using anonymous functions, we can write sums in a shorter way
*/

def sumInts(a:Int, b:Int) = sum(x => x, a, b)
def sumCubes(a:Int, b:Int) = sum(x => x * x * x, a, b)

/*
The sum function uses linear recursion. 
Write a tail-recursive version by replacing the ???s
*/

def sum(f: Int => Int)(a:Int. b:Int): Int = {
	def loop(a: Int, b: Int): Int = {
			if(???) ???
			else loop(???, ???)
  }
  loop(???, ???)
}

/* Solution*/

def sum(f: Int => Int)(a:Int. b:Int): Int = {
	def loop(a: Int, acc: Int): Int = {
			if(a > b) acc
			else loop(a+1, f(a) + acc)
  }
  loop(a, 0)
}

sum(x => x * x, 3, 5)
// squares summed between 3 and 5


}
