/* begin-class-Point */

class Point(initial_x: Double, initial_y: Double) {
   var x: Double = initial_x
   var y: Double = initial_y

   def move(dx: Double, dy: Double) {
      x = x + dx
      y = y + dy
   }

   def distanceToOrigin() : Double = {
      math.sqrt(x * x + y * y)
   }

   def distanceTo(p : Point) = {
      math.sqrt( (p.x - x) * (p.x - x) + (p.y - y) * (p.y - y) )
   }

   def add(p : Point) = {
      x = x + p.x
      y = y + p.y
      this
   }

   def +(p : Point) = {
      add(p)
   }

   override def toString(): String = s"($x, $y)";
}

/* end-class-Point */

/* begin-use-Point */
val p = new Point(2, 3)
val q = new Point(-2, 3)

println(s"Two points $p and $q")

val distanceToOrigin = p.distanceToOrigin()

println(s"distance from p to origin = $distanceToOrigin")

val dpq = p.distanceTo(q)
val dqp = q.distanceTo(p)

println(s"d(p,q) = $dpq")
println(s"d(q,p) = $dqp")

val pointSum = p.add(q)
val pointSumOp = p + q

println(s"p.add(q) = $pointSum; p + q = $pointSumOp")
/* end-use-Point */


/* begin-object-PointDemo */
object PointDemo {
   def apply() {
      val p = new Point(2, 3)
      val q = new Point(-2, 3)

      println(s"Two points $p and $q")

      val distanceToOrigin = p.distanceToOrigin()

      println(s"distance from p to origin = $distanceToOrigin")

      val dpq = p.distanceTo(q)
      val dqp = q.distanceTo(p)

      println(s"d(p,q) = $dpq")
      println(s"d(q,p) = $dqp")

      val pointSum = p.add(q)
      val pointSumOp = p + q

      println(s"p.add(q) = $pointSum; p + q = $pointSumOp")
   }
}

PointDemo()

/* end-object-PointDemo */

