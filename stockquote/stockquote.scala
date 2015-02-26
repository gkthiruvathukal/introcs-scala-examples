import scala.io._
import scala.util._

object StockQuote {

  def matchDateForYahoo(dateText: String, m: String, d: String, y: String): String = {
    val date = """(\d\d\d\d)-(\d\d)-(\d\d)""".r
    dateText match {
      case date(year, month, day) => {
        s"&${m}=${month.toInt - 1}&${d}=${day.toInt}&${y}=${year.toInt}"
      }
    }
  }

  def parseHeader(text: String) = {
    text.split(',')
  }

  def stockReport(headerLabels: Array[String], lines: Iterator[String]): Iterator[Map[String, String]] = {
    val requiredHeadings = Array("Date", "Open", "High", "Low", "Close", "Volume", "Adj Close")
    require(headerLabels.contains("Open"))
    require(headerLabels.contains("High"))
    require(headerLabels.contains("Low"))
    require(headerLabels.contains("Close"))
    require(headerLabels.contains("Volume"))
    require(headerLabels.contains("Adj Close"))

    lines map { line => headerLabels.zip(line.split(",")).toMap }
  }

  def getSummary(headerLabels: Array[String], lines: Iterator[String]) {

    val rowIterator = stockReport(headerLabels, lines)

    val rows = rowIterator.toList

    println("getSummary")
    rows foreach println
    println("getSummary done")

    // This is just an example of what is possible!
    val closeList = rows map { m => Try(m("Close").toDouble).getOrElse(0.0) }
    val highClose = closeList.max
    val lowClose = closeList.min
    println(s"high closing value $highClose; low closing value $lowClose")
    //map { entry => entry.get("Close") }.min

    //rintln("Mininum stock value = $minQuote")

  }

  def main(args: Array[String]) {
    val SYMBOL = "GOOG"
    val symbol = Try(args(0)).getOrElse(SYMBOL)
    val startDate = Try(args(0)).getOrElse("2015-01-01")
    val endDate = Try(args(1)).getOrElse("2015-02-05")

    val starting = matchDateForYahoo(startDate, "a", "b", "c")
    val ending = matchDateForYahoo(endDate, "d", "e", "f")
    val url = s"http://real-chart.finance.yahoo.com/table.csv?s=${symbol}${starting}${ending}&g=d"
    println(s"Getting $url")
    val data = Source.fromURL(url)
    val inLines = data.getLines
    val header = inLines.next()
    val headerLabels = parseHeader(header)
    getSummary(headerLabels, inLines)
  }
}
