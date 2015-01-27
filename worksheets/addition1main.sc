/*
 * This is just to show how to use Scala object to achieve the equivalent of the class-like boilerplate
 * found in Java and C#. Luckily, in early examples, we can work entirely with functions and never have to
 * touch classes/objects!
 */

object Addition1 {
	def SumProblem(x : Int, y : Int) {
		val sum = x + y
		val sentence = "The sum of " + x + " and " + y + " is " + sum + "."
		println(sentence)
	}

    def main(args: Array[String]) {
		SumProblem(2, 3)
		SumProblem(12345, 53579)
		println("Enter an integer: ")
		val a = Console.readInt()
		println("Enter another integer: ")
		val b = Console.readInt()
		SumProblem(a, b)
    }
}

Addition1.main(null)
