object Return1a {
  def main(args: Array[String]) {
    println(square(3))
    println(square(3))
    println(square(3) + square(4))
    checkPythagoreanTriple(3, 4, 5)
    checkPythagoreanTriple(3, 4, 6)
  }

  // simple functions can be 1-line in Scala!
  def square(x: Int): Int = x * x

  def checkPythagoreanTriple(a: Int, b: Int, c: Int) {
    println(s"${square(a)} + ${square(b)} == ${square(c)} is ${isPythagoreanTriple(a, b, c)}")
  }

  def isPythagoreanTriple(x: Int, y: Int, z: Int): Boolean =
    square(x) + square(y) == square(z)
}

