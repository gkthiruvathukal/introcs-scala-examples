import scala.util.Random.nextInt

case class SearchOutcome(status: Boolean, foundAt: Int)

object BinarySearching {

  def main(args: Array[String]) {
    val n = 10
    val MaxValue = 100
    val randInts = Array.fill(n)(nextInt(MaxValue))
    val sortedInts = randInts.sorted
    val outcomes = randInts map { item => intArrayBinarySearch(sortedInts, item) }
    val numberTrue = outcomes count { n => n.status == true }
    if (numberTrue == randInts.length)
      println("All random integers (1st set) were found successfully!")

    // now generate some values that shouldn't be found in the original sortedArray (of randInts)
    val randInts2 = Array.fill(n)(nextInt(MaxValue) + MaxValue)
    val outcomes2 = randInts2 map { item => intArrayBinarySearch(sortedInts, item) }
    val numberTrue2 = outcomes2 count { n => n.status == true }
    if (numberTrue2 == 0)
      println("All random integers (2nd set) were not found successfully")

    println("If you see 3 lines of output, this program works. We will use unit tests next time.")
  }

  def intArrayBinarySearch(data: Array[Int], item: Int): SearchOutcome = {
    var min = 0
    var max = data.length - 1
    var mid = -1
    var found = false
    while (min <= max && !found) {
      mid = (min + max) / 2;
      if (data(mid) == item)
        found = true
      if (item > data(mid))
        min = mid + 1
      else
        max = mid - 1
    }
    SearchOutcome(found, mid)
  }
}
