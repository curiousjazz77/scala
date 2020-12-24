package recfun

import scala.collection.mutable.Stack

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(col: Int, row: Int): Int = col match {
    case 0 => 1
    case col if col >= row => 1
    case _ => pascal(col - 1, row - 1) + pascal(col, row - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    val stack = new Stack[Char]


    def check(chars: List[Char], stackChecker: Stack[Char]): Boolean =

      if (chars.isEmpty) stackChecker.isEmpty

      else {
        chars.head match {
          case '(' => check(chars.tail, stackChecker.push(chars.head))
          case ')' => if (stackChecker.contains('(')) {
            stackChecker.pop()
            check(chars.tail, stackChecker)
          } else false
          case _ => check(chars.tail, stackChecker)
        }
      }

    check(chars, stack)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = money match {
    case 0 => 1
    case x if coins.isEmpty && x >= 1 => 0
    case x if x < 0 => 0
    case _ => countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
