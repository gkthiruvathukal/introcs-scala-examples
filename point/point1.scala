import math.{sqrt,pow}

object point1 {
  
  class Point(initX : Int, initY : Int) {
    val x = initX
    val y = initY
    
    def distanceTo(p : Point) : Double = {
      val sqr = (x : Double) => math.pow(x, 2)
      sqrt( sqr(p.x - x) + sqr(p.y - y) )
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
  
