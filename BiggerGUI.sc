// This is a large GUI example. There are two lists with a text fields and
// some buttons. The first list is populated by the text field and the buttons
// move things between lists or remove them from the second list.
//
// The populating from the text field demonstrates how you listen to GUI
// elements and react to them. The behavior of the lists shows how collection
// methods can play a role in GUIs.

import swing._
import event._

val list1 = new ListView[String]()
val list2 = new ListView[String]()
val buttons = new FlowPanel {
    contents += Button("<-") {
        list1.listData ++= list2.selection.items
        list2.listData = list2.listData.diff(list2.selection.items)
    }
    contents += Button("->") {
        list2.listData ++= list1.selection.items
        list1.listData = list1.listData.diff(list1.selection.items)
    }
    contents += Button("Remove") {
        list2.listData = list2.listData.diff(list2.selection.items)
    }
}
val field = new TextField() {
    listenTo(this)
    reactions += {
    case ed:
        EditDone =>
list1.listData :
        += text
        text = ""
    }
}

val frame = new MainFrame {
    contents = new BorderPanel {
        import BorderPanel.Position._
        layout += field -> North
        layout += new ScrollPane(list1) -> West
        layout += new ScrollPane(list2) -> East
        layout += buttons -> Center
    }
    size = new Dimension(600,500)
    centerOnScreen
}

frame.open
