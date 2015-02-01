object Interview {
  def main(args: Array[String]) {
  	print ( "Enter the interviewee's name: ")
    val name = readLine()
    print( "Enter the appointment time: ")
    val time = readLine()
    println(name + " has an interview at " + time + ".")
  }
}
