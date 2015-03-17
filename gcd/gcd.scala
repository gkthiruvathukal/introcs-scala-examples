import scala.util._
import math.abs

object gcd {

  def euclid(x: Int, y: Int): Int = {
    if (x == 0) y
    else if (x < 0) euclid(abs(x), y)
    else if (y < 0) euclid(x, abs(y))
    else euclid(y % x, x)
  }

  def main(args: Array[String]) {
    val a = Try(args(0).toInt).getOrElse(0)
    val b = Try(args(1).toInt).getOrElse(1)
    val gcd = euclid(a, b)
    println(s"euclid($a, $b) = $gcd")
  }
}
