import edu.luc.cs.ui._

object check_digits3 {
  def main(args: Array[String]) {
    val s = promptLine("Enter a line: ")
    val numDigits = countDigits(s)
    if (isDigits(s))
       println(s"All characters in $s are digits.")
    else
       println(s"$numDigits of ${s.length} characters  in $s are digits.")
  }

  def countDigits(s : String) = s.count( c => c >= '0' && c <= '9' )

  def isDigits(s : String) = countDigits(s) == s.length
}
