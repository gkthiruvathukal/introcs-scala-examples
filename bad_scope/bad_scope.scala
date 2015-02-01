object BadScope {
  def main(args: Array[String]) {
     val x = 3
     F()
     // Put code here
  }

  def F()
  {
     // uncomment the following line to get an compile (syntax) error
     // println(x)
  }
}
