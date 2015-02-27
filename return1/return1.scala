object Return1 {
  def main(args: Array[String]) {
    println(square(3))
    println(square(3))
    println(square(3) + square(4))
  }

  def square(x: Int): Int = {
    x * x
  }
}

