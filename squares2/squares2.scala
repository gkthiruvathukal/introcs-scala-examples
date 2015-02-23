import scala.util._

object Squares {

  def square(m: Int): Int = m * m

  def cube(n: Int): Int = square(n) * n

  def main(args: Array[String]) {
    val n = Try(args(0).toInt).getOrElse(100)
    (1 to n) map { n => (n, square(n), cube(n)) } foreach { tuple =>
       tuple match {
         case (n, nSquared, nCubed) => println(s"n = $n, $n^2 = $nSquared, $n^3 = $nCubed")
       }
    }
  }
}

