object constant {
   // constant, value not reset
  val PI = 3.14159265358979

  def circleArea(radius : Double) : Double = {
     PI*radius*radius
  }

  def circumference(radius : Double) : Double = {
     return 2*PI*radius
  }

  def main(args: Array[String]) {
     val radius=5
     println(s"circle area (radius=$radius) = ${circleArea(radius)}")
     println(s"circumference (radius=$radius) = ${circumference(radius)}")
  }
}
