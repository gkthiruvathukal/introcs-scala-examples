import edu.luc.cs.ui.promptDouble

object suitcase {

  def main(args: Array[String]) { //main chunk      
    val weight = promptDouble("How many pounds does your suitcase weigh? ", -1.0)
    if (weight > 50) {
      println("There is a $25 charge for luggage that heavy.");
    }
    if (weight > 0) {
      println("Thank you for your business.");
    }
  } // past main chunk
}
