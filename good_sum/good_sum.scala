object GoodSum {
  def main(args: Array[String]) {
    print("Enter an integer: ")
    val xString = readLine()
    val x = xString.toDouble
    print("Enter another integer: ")
    val yString = readLine()
    val y = yString.toDouble
    val sum = x + y;
    println("They add up to " + sum)
  }
}
