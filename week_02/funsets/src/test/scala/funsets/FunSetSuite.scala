package funsets

import org.junit._
import org.junit.Assert.{assertEquals, assertFalse, assertTrue}


/**
 * This class is a test suite for the methods in object FunSets.
 *
 * To run this test suite, start "sbt" then run the "test" command.
 */
class FunSetSuite {

  import FunSets._

  @Test def `contains is implemented`: Unit = {
    assert(contains(x => true, 100))
  }

  @Test def `doesn't contain element`: Unit = {
    Assert.assertFalse(contains(x => false, 100))
  }


  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)

    val s4 = singletonSet(1)
  }

  /**
   * This test is currently disabled (by using @Ignore) because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", remvoe the
   * @Ignore annotation.
   */
  @Test def `singleton set one contains one`: Unit = {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  @Test def `union contains all elements of each set`: Unit = {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  @Test def `intersect contains elements in both sets`: Unit = {
    new TestSets {
      val s = intersect(s1, s2)
      assert(!contains(s, 1), "Intersect 1")
      assert(!contains(s, 2), "Intersect 2")

      val t = intersect(s1, s4)
      assert(contains(t, 1), "Intersect 1")
    }
  }

  @Test def `set difference of items in s and not t`: Unit = {
    new TestSets {
      val s = diff(s1, s2)
      assert(contains(s, 1), "Intersect 1")
      assert(!contains(s, 2), "Intersect 2")
    }
  }

  @Test def `filter items in s that p holds`: Unit = {
    new TestSets {
      val p = union(s3, union(s1, s2)) // 1, 2, 3
      val s = union(s1, s2) // 1, 2
      val filtered = filter(s, p) // 1, 2; 3 omitted since wasnt in s
      assert(contains(filtered, 1), "Filtered 1")
      assert(contains(filtered, 2), "Filtered 2")
      assert(!contains(filtered, 3), "Filtered 3")
    }
  }

  @Test def `All bounded integers within s satisfy p`: Unit = {
    new TestSets {
      val p = union(s3, union(s1, s2)) // 1, 2, 3
      val s = union(s1, s2) // 1, 2
      assertTrue(forall(s, p))
    }
  }

  @Test def `NOT all bounded integers within s satisfy p`: Unit = {
    new TestSets {
      val p = union(s1, s2) // 1, 2
      val s = union(s1, s3) // 1, 3
      assertFalse(forall(s, p))
    }
  }

  @Test def `if a bounded number exists in s that satisfies p`: Unit = {
    new TestSets {
      val p = union(s1, s2) // 1, 2
      val s = union(s1, s3) // 1, 3
      assertTrue(exists(s, p))
    }
  }

  @Test def `a bounded number does NOT exist in s that satisfies p`: Unit = {
    new TestSets {
      val p = s1 // 1
      val s = s3 //  3
      assertFalse(exists(s, p))
    }
  }

  @Test def `apply function to each item in set s`: Unit = {
    new TestSets {
      val s = union(union(s1, s2), s3) // 1, 2, 3
      // multiply each item by two to get 2, 4, 6
      val newSet = map(s, x => x * 2)
      assert(contains(newSet, 2), "Mapped 1")
      assert(contains(newSet, 4), "Mapped 2")
      assert(contains(newSet, 6), "Mapped 3")
      assert(!contains(newSet, 1), "Mapped 4")
      assert(!contains(newSet, 3), "Mapped 5")
    }
  }

  @Test def `shows set`: Unit = {
    new TestSets {
      val s = union(union(s1, s2), s3) // 1, 2, 3
      // multiply each item by two to get 2, 4, 6
      val newSet = map(s, x => x * 2)

      val printedSet: String = FunSets.toString(newSet)
      assertEquals(printedSet, "{2,4,6}")
    }
  }

  @Rule def individualTestTimeout = new org.junit.rules.Timeout(10 * 1000)
}
