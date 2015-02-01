object MultilineString {
  def main(args: Array[String]) {
  	val text="""|George K. Thiruvathukal
  	            |Professor of Computer Science
  	            |Loyola University Chicago"""
        
    println("Text as is")         
    println(text)

    println("Text sans margin")
    println(text.stripMargin('|'))	
  }
}
