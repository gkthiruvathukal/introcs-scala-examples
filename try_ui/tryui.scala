/**
 * Created by gkt on 1/27/15.
 */
object TryUI {

  def main(args : Array[String]): Unit = {
    import edu.luc.cs.ui._

    val n = promptInt("What is your favorite number? ", -1)
    println(s"Thank you for entering the number $n.")
  }
}
