object birthday4 {

  def main(args: Array[String]) {
     happyBirthday("Emily", 21)
     println ("Hip hip hooray!")
     happyBirthday("Andre", 33)
  }

  def happyBirthday(person : String, years : Int) {
     println ("Happy Birthday to you!")
     println ("Happy Birthday to you!")
     println (s"Happy Birthday, dear $person.")
     println ("Happy Birthday to you!")

     println (s"$person is $years years old today.")
     val yearsMore = 100 - years
     println (s"Wishing you at least $yearsMore more!")
  }
}
