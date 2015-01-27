// This example shows how you can override the paint method to make a
// custom drawing. It also shows interactions with the mouse.

// begin-SimplePaint
import swing._
import event._
import java.awt.{Color,Shape}
import java.awt.geom._

var dots = List.empty[Shape]

val panel = new Panel {
  override def paint(g:Graphics2D) {
    g.setPaint(Color.white)
    g.fillRect(0,0,size.width,size.height)
    g.setPaint(Color.black)
    for(s <- dots) g.fill(s)
  }
  listenTo(mouse.clicks,mouse.moves)
  reactions += {
  case mc: MouseClicked =>
    dots ::= new Ellipse2D.Double(mc.point.x-2,mc.point.y-2,5,5)
    repaint
  case mc: MouseDragged =>
    dots ::= new Ellipse2D.Double(mc.point.x-2,mc.point.y-2,5,5)
    repaint
  }
}

val frame = new MainFrame {
  contents = panel
  size = new Dimension(600,600)
  centerOnScreen
}

frame.open
// end-SimplePaint
