import java.io.File

object files extends Traversable[File] {
  override def foreach[U](f: File => U): Unit = {
    def iter(file: File) : Unit =
      if (file.isDirectory)
        file.listFiles foreach iter
      else
        f(file)
    }
}

List( new File(".") ) foreach println
