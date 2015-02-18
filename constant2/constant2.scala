object constant2 {
  // constant, value not reset
  val PI = 3.14159265358979

  def circleArea(radius: Double): Double = {
    PI * radius * radius
  }

  def circumference(radius: Double): Double = {
    return 2 * PI * radius
  }

  def main(args: Array[String]) {
    val heading0 = "radius"
    val heading1 = "area"
    val heading2 = "circumference"
    println(f"$heading0%-10s $heading1%-10s $heading2%-10s")
    for (radius <- 1 to 10) {
      println(f"$radius%-10.2f ${circleArea(radius)}%-10.2f ${circumference(radius)}%-10.2f")
    }
  }
}
