object HelloYou2 {
  def main(args: Array[String]) {
    println("What is your name?")
    val name = readLine()
    println(s"Hello, $name!")
  }
}
