import org.scalatest._

import gcdSubtraction._

class EuclidTests extends FlatSpec with Matchers {

  "GCD" should "handle first argument being zero" in {
    gcd(0, 5) should be(5)
  }

  it should "handle second argument being zero" in {
    gcd(5, 0) should be(5)
  }

  it should "handle negative arguments properly" in {
    gcd(-5, 10) should be (5)
    gcd(5, -10) should be (5)
    gcd(-5, -10) should be (5)
  }
}
