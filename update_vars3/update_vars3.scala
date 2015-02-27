object UpdateVars3 {
  def main(args: Array[String]) {
    var x: Int = 3
    var y: Int = x + 2
    y = 2 * y
    x = y - x
    println(s"x = $x, y = $y")
  }
}
