import scala.util._

case class EuclidState(sign : Int, x : Int, y : Int)

object gcd2 {

  /*
  Recursive version:

  def euclid(x: Int, y: Int): Int = {
    if (x == 0) y
    else if (x < 0) euclid(-x, y)
    else if (y < 0) -euclid(x, -y)
    else euclid(y % x, x)
  }
  */

  def gotoNextState( state : EuclidState ): EuclidState = {
    if (state.x == 0)
       EuclidState(state.sign, 0, state.y)
    else if (state.x < 0)
       EuclidState(state.sign, -state.x, state.y)
    else if (state.y < 0)
       EuclidState(-state.sign, state.x, -state.y)
    else
       EuclidState(state.sign, state.y % state.x, state.x)
  }

  /*
   * Version sans recursion!
   */

  def euclid(x : Int, y : Int): Int = {
    val initState = EuclidState(1, x, y)
    val results = Iterator.iterate(initState)(gotoNextState) dropWhile (state => state.x != 0)
    val finalState = results.next
    finalState.sign * finalState.y
  }


  def main(args: Array[String]) {
    val a = Try(args(0).toInt).getOrElse(0)
    val b = Try(args(1).toInt).getOrElse(1)
    val gcd = euclid(a, b)
    println(s"euclid($a, $b) = $gcd")
  }
}
