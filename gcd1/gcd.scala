import scala.util._
import math.abs

object gcd1 {

  /*
   * This version simplifies euclid() by enlisting the help of a nested function, euclidHelper()
   * that assumes both inputs are not negative.
   */

  def euclid(x: Int, y: Int): Int = {
    def euclidHelper(x : Int, y : Int) : Int = {
       if (x == 0) y
       else euclidHelper(y % x, x)
    }
    euclidHelper(abs(x), abs(y))
  }

  def main(args: Array[String]) {
    val a = Try(args(0).toInt).getOrElse(0)
    val b = Try(args(1).toInt).getOrElse(1)
    val gcd = euclid(a, b)
    println(s"euclid($a, $b) = $gcd")
  }
}
