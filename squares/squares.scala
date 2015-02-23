import scala.util._

object Squares {

  def square(m: Int): Int = m * m

  def cube(n: Int): Int = square(n) * n

  def main(args: Array[String]) {
    val n = Try(args(0).toInt).getOrElse(100)
    for (i <- 1 to n) {
      println(s"i = $i, square($i) = ${square(i)} cube($i) = ${cube(i)}")
    }
  }
}

