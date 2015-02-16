object string_play {
  def main(args: Array[String]) {
		println("Enter three lines:")
		val line1 = readLine()
		val line2 = readLine()
		val line3 = readLine()

		println("Lines in opposite order:")
		println(line3)
    println(line2)
    println(line1)

    println("First line in upper case:  " + line1.toUpperCase)
  }
}
