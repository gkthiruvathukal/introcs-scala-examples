import math.{sqrt,pow}

object point2 {
  
  // a case class allows you to avoid coming up with different names for
  // constructing the instance (when you can live with val).
  // Note how this allows for a much nicer implementation of distanceTo()

  case class Point(x : Int, y : Int) {
    def distanceTo(p : Point) : Double = {
      val sqr = (x : Double) => math.pow(x, 2)
      p match {
        case Point(x1, y1) => sqrt( sqr(x1 - x) + sqr(y1 - y) )
      }
    }
  }
  
  def main(args : Array[String]) {
    val p0 = new Point(3, 3)
    val p1 = new Point(3, 6)    // d(p0, p1) = 3
    val p2 = new Point(7, 6)    // d(p1, p2) = 4
    
    println("d(p0,p1) = " + p0.distanceTo(p1))
    println("d(p1,p2) = " + p1.distanceTo(p2))
    println("d(p0,p2) = " + p0.distanceTo(p2))
    
  }
}
  
