import org.scalatest._

import gcd2._

class EuclidTests extends FlatSpec with Matchers {

  "GCD" should "handle first argument being zero" in {
    euclid(0, 5) should be(5)
  }

  it should "handle second argument being zero" in {
    euclid(5, 0) should be(5)
  }

  it should "handle negative arguments properly" in {
    euclid(-5, 10) should be (5)
    euclid(5, -10) should be (5)
    euclid(-5, -10) should be (5)
  }
}
