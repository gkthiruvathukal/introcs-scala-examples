
object contact2 {

  case class Contact(name : String, phone : String, email : String)
  
  def main(args: Array[String]) {
    println("Creating two Contact objects")

    val c1 = new Contact("Marie Ortiz", "773-508-7890", "mortiz2@luc.edu");
    val c2 = new Contact("Otto Heinz", "773-508-9999", "oheinz@luc.edu");

    c1 match {
      case Contact(name, phone, email) => {
        println(s"Marie's full name = ${name}")
        println(s"Marie's phone number = ${phone}")
        println(s"Marie's e-mail = ${email}")
      }
    }

    println(s"Otto's full contact info = ${c2}")

    println("Adding contacts to List[Contact]")
    val contacts = List(c1, c2)

    println("Printing all contacts in List[Contact]")
    contacts foreach println

    println("Find contact with a specific phone number")
    contacts filter { c => c.phone == "773-508-7890" } foreach println
  }
}
