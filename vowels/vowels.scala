import edu.luc.cs.ui._

object Vowels {
   def main(args: Array[String]) {
      val s = promptLine("Enter a line: ")
      printVowels(s)
   } 
      //                                         new chunk
      /// Print the vowels (aeiou) in s, one per line.
   def printVowels(s : String) {
      var i = 0
      while (i < s.length) {
         if (s(i) == 'a' || s(i) == 'e' || s(i) == 'i' ||
            s(i) == 'o' || s(i) == 'u') {
               println(s(i))
         }
         i = i + 1
      }
   }
}
