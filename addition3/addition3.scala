import edu.luc.cs.ui.promptInt

object Addition3 {

   def sumProblemString(x : Int, y : Int) : String = {
      val sum = x + y
      val sentence = s"The sum of $x and $y is $sum."
      sentence
   }

   def main(args: Array[String]) {
      println(sumProblemString(2, 3))
      println(sumProblemString(12345, 53579))
      val a = promptInt("Enter an integer: ", -1)
      val b = promptInt("Enter another integer: ", -1)
      println(sumProblemString(a, b))
   }
}
