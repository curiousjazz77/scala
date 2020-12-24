package funsets

/**
 * 2. Purely Functional Sets.
 */
trait FunSets extends FunSetsInterface {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  override type FunSet = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: FunSet, elem: Int): Boolean = s(elem)

  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): FunSet = {
    (value: Int) => {
      value == elem
    }
  }


  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: FunSet, t: FunSet): FunSet = {
    (value: Int) => {
      contains(s, value) | contains(t, value)
    }
  }

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: FunSet, t: FunSet): FunSet = {
    (value: Int) => {
      contains(s, value) && contains(t, value)
  }
}
  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: FunSet, t: FunSet): FunSet = {
    (value: Int) => {
      contains(s, value) && !contains(t, value)
    }
  }

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: FunSet, p: Int => Boolean): FunSet = {
    (value: Int) => s(value) && p(value)
  }


  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: FunSet, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (contains(s, a) && !p(a)) false
      else iter(a+1)
    }
    iter(-bound)
  }

  def size(s: FunSet): Int = {
    val accumulator = 0

    def iter(a: Int): Int = {
      if (a > bound) accumulator
      else if (contains(s, a)) {
        val newacc = accumulator + 1
        newacc
      }
      else iter(a+1)
    }
    iter(-bound)
  }

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: FunSet, p: Int => Boolean): Boolean = {
    // accumulator, each time forAll is called
    // return early if accum increments to == 1
    val subset = filter(s, p)
    if (size(subset) == 0) false
    else if (!forall(subset, p)) false else true
  }

//  def exists(s: FunSet, p: Int => Boolean): Boolean = {
//    // return early if we find the right item
//    def iter(a: Int): Boolean = {
//      if (a > bound) false
//      else if (contains(s, a) && p(a)) true
//      else iter(a+1)
//    }
//    iter(-bound)
//  }
  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  def map(s: FunSet, f: Int => Int): FunSet = {
    def iter(a: Int, accum: FunSet): FunSet = {
      if (a > bound) accum
      else if (contains(s, a)) iter(a+1, union(accum, singletonSet(f(a))))
      else iter(a+1, accum)
    }
    // -bound - 1 (or bound +1) will never union as we progress across the set
    iter(-bound, singletonSet(-bound-1))
  }

  /**
   * Displays the contents of a set
   */
  def toString(s: FunSet): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")

  }

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: FunSet): Unit = {
    println(toString(s))
  }
}

object FunSets extends FunSets
