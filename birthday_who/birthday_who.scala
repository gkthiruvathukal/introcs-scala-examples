object birthday_who {

   def happyBirthday(person : String)
   {
      println("Happy Birthday to you!")
      println("Happy Birthday to you!")
      println("Happy Birthday, dear " + person + ".")
      println("Happy Birthday to you!")
   }

   def main(args : Array[String])
   {
      println("Who would you like to sing Happy Birthday to?")
      val userName = readLine()
      happyBirthday(userName)
   }

}
