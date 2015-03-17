import scala.util._
import math.abs

case class EuclidState(x : Int, y : Int)

object gcd2 {

  /*
  Recursive version:

  def euclid(x: Int, y: Int): Int = {
    if (x == 0) y
    else if (x < 0) euclid(abs(x), y)
    else if (y < 0) euclid(x, abs(y))
    else euclid(y % x, x)
  }
  */

  def gotoNextState( state : EuclidState ): EuclidState = {
    if (state.x == 0)
       EuclidState(0, state.y)
    else if (state.x < 0)
       EuclidState(abs(state.x), state.y)
    else if (state.y < 0)
       EuclidState(state.x, abs(state.y))
    else
       EuclidState(state.y % state.x, state.x)
  }

  /*
   * Version sans recursion!
   */

  def euclid(x : Int, y : Int): Int = {
    val initState = EuclidState(x, y)
    val results = Iterator.iterate(initState)(gotoNextState) dropWhile (state => state.x != 0)
    val finalState = results.next
    finalState.y
  }


  def main(args: Array[String]) {
    val a = Try(args(0).toInt).getOrElse(0)
    val b = Try(args(1).toInt).getOrElse(1)
    val gcd = euclid(a, b)
    println(s"euclid($a, $b) = $gcd")
  }
}
