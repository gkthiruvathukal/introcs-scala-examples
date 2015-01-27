/*
 * This shows how to write a Scala worksheet. Notice that similar to other agile languages (e.g. Python)
 * we can create functions and statements w/o any boilerplate! The added advantage is complete type safety
 * (static typing). We also have val and var for creating immutable and mutable variables. We will avoid
 * var unless necessary for teaching some historical algorithms.
 */

def SumProblem(x : Int, y : Int) {
	val sum = x + y
	val sentence = "The sum of " + x + " and " + y + " is " + sum + "."
	println(sentence)
}

SumProblem(2, 3)
SumProblem(12345, 53579)
println("Enter an integer: ")
val a = Console.readInt()
println("Enter another integer: ")
val b = Console.readInt()
SumProblem(a, b)