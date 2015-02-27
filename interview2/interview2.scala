object Interview {

  def InterviewSentence(name: String, time: String) = {
    s"$name has an interview at $time."
  }

  def main(args: Array[String]) {
    print ("Enter the interviewee's name: ")
    val name = readLine()
    print("Enter the appointment time: ")
    val time = readLine()
    println(InterviewSentence(name, time))
  }
}
