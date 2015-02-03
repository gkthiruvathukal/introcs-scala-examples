object return2 {
  def main(args: Array[String]) {
     println(arrangeLastFirst("Marie", "Curie"))
     println(arrangeLastFirst("Benjamin", "Franklin"))
     println(arrangeLastFirst("Andrew", "Harrington"))
     println(arrangeLastFirst("George", "Thiruvathukal"))
  }

  def arrangeLastFirst(firstName : String, lastName : String) = {
     val separator = ", "
     val result = lastName + ", " + firstName
     result
  }
}
