import edu.luc.cs.ui._
import math.abs

object g_c_d_subtraction_method {
  def main(args: Array[String]) {
    val a = promptInt("Enter an integer: ", 1)
    val b = promptInt("Enter another integer: ", 1)
    val result = gcd(a, b)
    println(s"gcd($a, $b) = $result (using subtraction method)")
  }

  def gcd(x : Int, y : Int) : Int = {
    var a = math.abs(x)
    var b = math.abs(y)
    require (a != 0)
    require (b != 0)
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
}
