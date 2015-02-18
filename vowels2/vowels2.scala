import edu.luc.cs.ui._

object Vowels2 {
  def main(args: Array[String]) {
    val s = promptLine("Enter a line: ")
    printVowels(s)
  }
  //                                         new chunk
  /// Print the vowels (aeiou) in s, one per line.
  def printVowels(s: String) {
    var i = 0
    while (i < s.length) {
      val vowels = "aeiouAEIOU"
      if (vowels.contains(s(i))) {
        println(s(i))
      }
      i = i + 1
    }
  }
}