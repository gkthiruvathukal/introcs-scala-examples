import edu.luc.cs.ui._

object Vowels3 {
  def main(args: Array[String]) {
    val s = promptLine("Enter a line: ")
    printVowels(s)
  }
  //                                         new chunk
  /// Print the vowels (aeiou) in s, one per line.
  def printVowels(s: String) {
    val vowels = "aeiouAEIOU"
    for (c <- s) {
      if (vowels.contains(c)) {
        println(c)
      }
    }
  }
}