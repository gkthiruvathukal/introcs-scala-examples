<<<<<<< HEAD
=======
import scala.io._
import scala.util._
>>>>>>> d8727ea71aac2613d862d4a8567545f22dae1cda

object StockQuote {
  
  def main(args : Array[String]) {
<<<<<<< HEAD

  }
   

  :
  Source.fromURL("http://finance.yahoo.com/d/quotes.csv?s=GOOG&f=snbaop11")
=======
     val SYMBOL = "GOOG"
     val symbol = Try(args(0)).getOrElse(SYMBOL)
 
     url = s"http://finance.yahoo.com/d/quotes.csv?s=$symbol&f=snbaop11")
     data = Source.fromURL(url)
     for (datum <- data.getLines)
        println(datum)
     
  }
>>>>>>> d8727ea71aac2613d862d4a8567545f22dae1cda
}
