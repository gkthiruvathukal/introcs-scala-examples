/*
 * imperative version, brute force, GCD
 */

def GreatestCommonDivisor(a : Int, b : Int) : Int = {
	val n = math.min(a, b)
	var gcd = 1
	var i = 1

	while (i <= n) {
		if (a % i == 0 && b % i == 0)
			gcd = i
		i = i + 1;
	}
	return gcd
}

println("Enter an integer: ")
val a = Console.readInt()
println("Enter another integer: ")
val b = Console.readInt()
val gcd = GreatestCommonDivisor(a, b)
println(s"The greatest common divisor of $a and $b is $gcd.")