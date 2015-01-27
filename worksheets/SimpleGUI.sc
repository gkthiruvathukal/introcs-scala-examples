// This example shows a simple GUI where there is no inheritance.
// Clicking the button increments the number in the text field. If the user
// has changed it so that it is not an integer, it is set back to 0.
//
// Those familiar with Java will notice a lot of similarities. This is because
// the scala.swing library is a wrapper around Java's Swing library. The
// ideas are similar, but the way in which you interact with them has been
// changed to match the Scala style.

// begin-SimpleGUI
import swing._

val frame = new MainFrame
val field = new TextField("0")
val button = Button("Increment") {
    try {
        field.text = (field.text.toInt+1).toString
    } catch {
    case ex:
        NumberFormatException => field.text = "0"
    }
}

val bp = new BorderPanel
import BorderPanel.Position._
bp.layout += field -> North
bp.layout += button -> Center
frame.contents = bp
frame.centerOnScreen
frame.open

// end-SimpleGUI
