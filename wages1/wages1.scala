import edu.luc.cs.ui.promptDouble

object Wages1 {
  def calcWeeklyWages(totalHours : Double, hourlyWage : Double) = {
     if (totalHours <= 40) {
       hourlyWage*totalHours
     }
     else {
       val overtime = totalHours - 40
       hourlyWage*40 + (1.5*hourlyWage)*overtime
     }
  }

  def main(args : Array[String]) {
     val hours = promptDouble("Enter hours worked: ", 0)
     val wage = promptDouble("Enter dollars paid per hour: ", 0)
     val total = calcWeeklyWages(hours, wage)  //before chunk2
     println(f"Wages for $hours hours at $wage%.2f per hour are $total%.2f.")
   }
}
