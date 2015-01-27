// This version of Painting is with inferred data types
// (similar to C# var)


object Painting2 {
  def main(args: Array[String]) {
    println("Hello, world!")
    val HEIGHT = 8.0

    println("Calculation of Room Paint Requirements")
    println("Enter room length: ")
    val lengthString = readLine()
    val length = lengthString.toDouble
    println("Enter room width: ")
    val widthString = readLine()
    val width = widthString.toDouble

    // ignore doors
    val wallArea = 2 * (length + width) * HEIGHT

    val ceilingArea = length * width

    println(s"The wall area is $wallArea square feet.")
    println(s"The ceiling area is $ceilingArea square feet.")
  }
}
