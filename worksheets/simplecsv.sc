# Some fragments/hints for COMP 170 Homework 2/3
#

def getCSV(line : String) : Array[String] = {
  val tokens = line.split(",")
  for (i <- 0 until tokens.length)
    tokens(i) = tokens(i).trim
  tokens
}

val results = getCSV("George, likes,    Scala, in,   COMP 170   ")

results foreach println

