import edu.luc.cs.ui._

object check_digits1 {
  def main(args: Array[String]) {
    val s = promptLine("Enter a line: ")
    if (isDigits(s))
       println(s"All characters in $s are digits.")
    else
       println(s"Some characters in $s are not digits.")
  }

  def isDigits(s : String) : Boolean = {
    var allDigitsSoFar = true
    var i = 0
    while (i < s.length && allDigitsSoFar) {
      if (s(i) < '0' || s(i) > '9') {
        allDigitsSoFar = false
      }
      i += 1
    }
    allDigitsSoFar
  }
}
