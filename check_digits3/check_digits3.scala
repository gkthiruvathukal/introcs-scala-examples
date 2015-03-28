import edu.luc.cs.ui._

object check_digits3 {
  def main(args: Array[String]) {
    val s = promptLine("Enter a line: ")
    if (isDigits(s))
       println(s"All characters in $s are digits.")
    else
       println(s"Some characters in $s are not digits.")
  }

  def isDigits(s : String) : Boolean = {
    val digits = s.takeWhile( c => c >= '0' && c <= '9' )
    digits.length = s.length
  } 
}
