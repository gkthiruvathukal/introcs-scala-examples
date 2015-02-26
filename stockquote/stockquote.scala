import scala.io._
import scala.util._

object StockQuote {
  
  def matchDateForYahoo( dateText : String, m : String, d : String, y : String) : String = {
  	val date = """(\d\d\d\d)-(\d\d)-(\d\d)""".r
  	dateText match {
      case date(year, month, day) => {
      	s"&${m}=${month.toInt-1}&${d}=${day.toInt}&${y}=${year.toInt}"
      }
    }
  }

  def main(args : Array[String]) {
     val SYMBOL = "GOOG"
     val symbol = Try(args(0)).getOrElse(SYMBOL)

     val startDate = Try(args(0)).getOrElse("2015-01-01")
     val endDate = Try(args(1)).getOrElse("2015-02-05")

     val starting = matchDateForYahoo(startDate, "a", "b", "c")
     val ending = matchDateForYahoo(endDate, "d", "e", "f")
     val url = s"http://real-chart.finance.yahoo.com/table.csv?s=${symbol}${starting}${ending}&g=d"
     println(url)
     val data = Source.fromURL(url)
     for (datum <- data.getLines)
        println(datum)
  }
}
