// This version is one where every Scala variable (val) 
// is declared with an explicit data type.

object Hello {
  def main(args: Array[String]) {
    println("Hello, world!")
    val HEIGHT : Double = 8.0

    println("Calculation of Room Paint Requirements")
    println("Enter room length: ")
    val lengthString : String = readLine()
    val length : Double = lengthString.toDouble
    println("Enter room width: ")
    val widthString : String = readLine()
    val width : Double = widthString.toDouble

    // ignore doors
    val wallArea : Double = 2 * (length + width) * HEIGHT

    val ceilingArea : Double = length * width

    println(s"The wall area is $wallArea square feet.")
    println(s"The ceiling area is $ceilingArea square feet.")
  }
}
