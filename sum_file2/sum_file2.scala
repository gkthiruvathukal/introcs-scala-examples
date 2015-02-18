import scala.io._
import scala.util.{ Try, Success, Failure }
import edu.luc.cs.ui._

object SumFile2 {
  def main(args: Array[String]) {
    val filename = promptLine("Enter a file of integers: ")
    val result = CalcSum(filename)
    val succeeded = result._1
    val sum = result._2
    if (succeeded) {
      println(s"Sum is $sum")
    } else {
      println(s"Could not open $filename")
    }
  }

  def CalcSum(filename: String): (Boolean, Int) = {
    val tryFile = Try(Source.fromFile(filename))
    tryFile match {
      case Success(file) => (true, file.getLines flatMap { n => Try(n.toInt).toOption } sum)
      case Failure(file) => (false, 0)
    }
  }
}
