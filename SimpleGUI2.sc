// This example shows a simple GUI where there is no inheritance.
// Clicking the button increments the number in the text field. If the user
// has changed it so that it is not an integer, it is set back to 0.
//
// Those familiar with Java will notice a lot of similarities. This is because
// the scala.swing library is a wrapper around Java's Swing library. The
// ideas are similar, but the way in which you interact with them has been
// changed to match the Scala style.
// 
// This shows how to do field validation using Scala's options. 

// begin-SimpleGUI2
import scala.swing._
import scala.util.Try

val frame = new MainFrame
val field = new TextField("0")

val button = Button("Increment") {
  val attempt = Try(field.text.toInt) 
  field.text = (attempt.getOrElse(-1)+1).toString
}

val bp = new BorderPanel
import BorderPanel.Position._
bp.layout += field -> North
bp.layout += button -> Center
frame.contents = bp
frame.centerOnScreen
frame.open

// end-SimpleGUI2
