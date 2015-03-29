import edu.luc.cs.ui._
import math.abs

object gcdSubtraction {
  def main(args: Array[String]) {
    val a = promptInt("Enter an integer: ", 1)
    val b = promptInt("Enter another integer: ", 1)
    val result = gcd(a, b)
    println(s"gcd($a, $b) = $result (using subtraction method)")
  }

  def gcd(x : Int, y : Int) : Int = {

    // Subtraction method assumes x > 0 && y > 0
    def gcdSubtractionMethod(x : Int, y : Int) : Int =  {
      var a = x
      var b = y
      var c = 0
      while (a != b) {
       while (a > b) {
         c =  a - b
         a = c
       }
       while (b > a) {
         c = b - a
         b = c
       }
      }
      a
    }

    // Only call the subtraction method for non-zero x and y
    // It doesn't work otherwise. Inputs are taken at absolute value.

    if (x == 0)
      y
    else if (y == 0)
      x
    else 
      gcdSubtractionMethod( abs(x), abs(y) )
  }
}
