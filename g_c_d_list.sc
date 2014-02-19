/*
 * functional version, brute force, GCD
 */

def GreatestCommonDivisor(a : Int, b : Int) : Int = {
	val n = math.min(a, b)
	val numbers = 1 to n
	val divides_a = numbers.filter( i => a % i == 0)
	val divides_a_and_b = divides_a.filter(i => b % i == 0)
	val gcd = divides_a_and_b.last
	gcd
}

println("Enter an integer: ")
val a = Console.readInt()
println("Enter another integer: ")
val b = Console.readInt()
val gcd = GreatestCommonDivisor(a, b)
println(s"The greatest common divisor of $a and $b is $gcd.")