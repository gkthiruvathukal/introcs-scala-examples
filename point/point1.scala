import math.{sqrt,pow}

object point1 {
  
  class Point(initX : Double, initY : Double) {
    val x = initX
    val y = initY
    
    def distanceTo(p : Point) : Double = {
      val sqr = (x : Double) => math.pow(x, 2)
      sqrt( sqr(p.x - x) + sqr(p.y - y) )
    }
    
    def translate(dx : Double, dy : Double) = new Point(x + dx, y + dy) 

    def translate(p : Point) = new Point(x + p.x, y + p.y) 

    override def toString() = s"Point($x, $y)"
  }
  
  def main(args : Array[String]) {
    val p0 = new Point(3, 3)
    val p1 = new Point(3, 6)    // d(p0, p1) = 3
    val p2 = new Point(7, 6)    // d(p1, p2) = 4
    
    println("d(p0,p1) = " + p0.distanceTo(p1))
    println("d(p1,p2) = " + p1.distanceTo(p2))
    println("d(p0,p2) = " + p0.distanceTo(p2))
    
    val q0 = p0.translate(-3, -3)
    val q1 = p1.translate(-3, -3)
    val q2 = p2.translate(-3, -3)

    println(q0)
    println(q1)
    println(q2)

    println("d(q0,q1) = " + q0.distanceTo(q1))
    println("d(q1,q2) = " + q1.distanceTo(q2))
    println("d(q0,q2) = " + q0.distanceTo(q2))
  }
}
  
