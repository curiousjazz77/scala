import scala.annotation.tailrec

object tail_recursion extends App {

  @tailrec
  def gcd(a: Int, b:Int): Int = {
    //Euclid's algorithm
    // reduction sequence oscillates
    if (b==0) a else gcd(b, a % b) //calls itself as its last action
    // translates into a tail recursive call
    // that can execute in constant space
  }

  gcd(14, 21)

  def factorial(n:Int): Int  = {
    //expressions get bigger until we get final value
    // NOT tail recursive
    if (n==0) 1 else n * factorial(n -1)
  }

  factorial(4)
  
  @tailrec
  def factorialTail(n:Int): Int = {
    
    def loop(acc:Int, n: Int): Int =
      if (n==0) acc else loop(acc*n, n-1)
    loop(1, n)
  }

  factorialTail(4)
}
