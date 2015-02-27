import org.scalatest._

import gcd._

class EuclidTests extends FlatSpec with Matchers {

  "GCD involving 0" should "give y for euclid(0, y)" in {
    euclid(0, 5) should be(5)
  }

  it should "give x for euclid(x, 0)" in {
    euclid(0, 5) should be(5)
  }

  "GCD not involving 0" should "be 3" in {
    euclid(3 * 1, 3 * 3) should be(3)
  }

  it should "be 5" in {
    euclid(5 * 1, 5 * 5) should be(5)
  }
}
