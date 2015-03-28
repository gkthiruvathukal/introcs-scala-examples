
object contact2 {
  class Contact(initName : String, initPhone : String, initEmail : String) {
    var name = initName
    var phone = initPhone
    var email = initEmail
    override def toString(): String = s"Contact($name, $phone, $email)"
  }
  
  def main(args: Array[String]) {
    println("Creating two Contact objects")

    val c1 = new Contact("Marie Ortiz", "773-508-7890", "mortiz2@luc.edu");
    val c2 = new Contact("Otto Heinz", "773-508-9999", "oheinz@luc.edu");

    println(s"Marie's full name = ${c1.name}")
    println(s"Marie's phone number = ${c1.phone}")
    println(s"Marie's e-mail = ${c1.phone}")
    println(s"Otto's full contact info = ${c2}")

    // Change Otto's contact info to show mutable state
    c2.email = "otto@otto.com" // Otto's new e-mail addy
    println(s"Otto's new contact info = ${c2}")
    
    
    
    println("Adding contacts to List[Contact]")
    val contacts = List(c1, c2)

    println("Printing all contacts in List[Contact]")
    contacts foreach println

    println("Find contact with a specific phone number")
    contacts filter { c => c.phone == "773-508-7890" } foreach println

  }
}
