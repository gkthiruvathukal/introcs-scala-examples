object Addition2a {

  def sumProblemString(x: Int, y: Int): String = {
    val sum = x + y
    val sentence = s"The sum of $x and $y is $sum."
    sentence
  }

  def main(args: Array[String]) {
    println(sumProblemString(2, 3))
    println(sumProblemString(12345, 53579))
    print("Enter an integer: ")
    val a = readInt()
    print("Enter another integer: ")
    val b = readInt()
    println(sumProblemString(a, b))
  }
}
