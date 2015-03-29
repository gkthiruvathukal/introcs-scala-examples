import edu.luc.cs.ui._
import scala.util.control.Breaks

object check_digits2 {
  def main(args: Array[String]) {
    val s = promptLine("Enter a line: ")
    if (isDigits(s))
       println(s"All characters in $s are digits.")
    else
       println(s"Some characters in $s are not digits.")
  }

  def isDigits(s : String) : Boolean = {
    val myControl = new Breaks()
    import myControl.{breakable, break}

    var allDigitsSoFar = true
    breakable {
      for (i <- 0 until s.length) {
        println("checking " + s(i))
        if (s(i) < '0' || s(i) > '9') {
          allDigitsSoFar = false
          break()
        }
      }
    }
    allDigitsSoFar
  }
}
