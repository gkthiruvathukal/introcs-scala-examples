import scala.util.Random.nextInt

/*
 * Side-effect-free version of Binary Searching.
 *
 * This shows the use of Scala's Iterator.iterator() to reach a final state ((SearchState). 
 * dropWhile() is used to drop state until either min >= max. As in the two previous imperative
 * versions, this condition means that the value was either found or not found, which can be 
 * determined by examining the SearchState.foundAt property.
 *
 * Big acknowledgment to @klaeufer (on GitHub) for helping to identify Iterator.iterator().
 */

case class SearchState(data: Array[Int], item: Int, min: Int, max: Int, foundAt: Int)

object BinarySearching3 {

  def nextState(data: Array[Int], min: Int, max: Int, item: Int): SearchState = {
    val mid = (min + max) / 2
    if (min > max)
      SearchState(data, item, min, max, -1)
    else if (item == data(mid))
      SearchState(data, item, mid, mid, mid)
    else if (item > data(mid))
      SearchState(data, item, mid + 1, max, -1)
    else
      SearchState(data, item, min, mid, -1)
  }

  def gotoNextState(state: SearchState) = nextState(state.data, state.min, state.max, state.item)

  def intArrayBinarySearch(data: Array[Int], item: Int): Int = {
    val initState = SearchState(data, item, 0, data.length, -1)
    val results = Iterator.iterate(initState)(gotoNextState) dropWhile (state => state.min < state.max)
    val finalState = results.next
    finalState.foundAt
  }

  def main(args: Array[String]) {
    val n = 10
    val MaxValue = 100
    val randInts = Array.fill(n)(nextInt(MaxValue))
    val sortedInts = randInts.sorted
    val outcomes = randInts map { item => intArrayBinarySearch(sortedInts, item) }
    val numberFound = outcomes count { _ >= 0 }
    if (numberFound == randInts.length)
      println("All random integers (1st set) were found successfully!")

    // now generate some values that shouldn't be found in the original sortedArray (of randInts)
    val randInts2 = Array.fill(n)(nextInt(MaxValue) + MaxValue)
    val outcomes2 = randInts2 map { item => intArrayBinarySearch(sortedInts, item) }
    val numberFound2 = outcomes2 count { _ >= 0 }
    if (numberFound2 == 0)
      println("All random integers (2nd set) were not found successfully")

    println("If you see 3 lines of output, this program works. We will use unit tests next time.")
  }
}
