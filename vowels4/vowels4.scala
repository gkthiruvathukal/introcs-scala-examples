import edu.luc.cs.ui._

// This is a bit more advanced example that shows how to 
// use a Scala for-comprehension to generate the vowels from a string
// to produce an array of char. Then we use this to produce a Scala
// set (to idenitfy the unique vowels).

object Vowels4 {
   def main(args: Array[String]) {
      val s = promptLine("Enter a line: ")
      printVowels(s)
      printUniqueVowels(s)

   }
   
   def generateVowels(s : String) : Array[Char] = {
      val vowels = "aeiouAEIOU"
      for { 
         c <- s.toCharArray
         if (vowels contains c)
      } yield {
         c
      }
   }

   def printVowels(s : String) {
      println("Vowels found (includes duplicates)")
      generateVowels(s) map println
   }

   def printUniqueVowels(s : String) {
      println("Vowels found (unique)")
      val vowelSet = generateVowels(s).toSet
      vowelSet map println
   }

}
