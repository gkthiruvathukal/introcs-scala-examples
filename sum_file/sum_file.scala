import scala.io._
import scala.util.{ Try, Success, Failure }
import edu.luc.cs.ui._

object SumFile {
  def main(args: Array[String]) {
    val filename = promptLine("Enter a file of integers: ")
    val fileSum = CalcSum(filename)
    println(s"Sum is $fileSum")
  }

  def CalcSum(filename: String): Int = {
    var sum = 0
    for (file <- Try(Source.fromFile(filename)).toOption) {
      println(s"Reading $filename")
      for (line <- file.getLines) {
        val amountOpt = Try(line.toInt)
        val amount = amountOpt.getOrElse(0)
        println(s"$line = $amount (0 if not an Int)")
        sum = sum + amount
      }
    }
    sum
  }
}
