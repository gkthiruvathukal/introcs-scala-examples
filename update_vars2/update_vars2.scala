object UpdateVars2 {
  def main(args: Array[String]) {
    var a: Int = 5
    var b: Int = 2 * a
    a = a * b
    b = a - b
    a = a + b
    println(s"a = $a, b = $b")
  }
}
