import scala.util.Random.nextInt

case class SearchOutcome(status : Boolean, foundAt : Int)

object BinarySearching2 {

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
    val outcomes2 = randInts2  map { item => intArrayBinarySearch(sortedInts, item) }
    val numberTrue2 = outcomes2 count { n => n.status == true }
    if (numberTrue2 == 0)
      println("All random integers (2nd set) were not found successfully")

    println("If you see 3 lines of output, this program works. We will use unit tests next time.")
  }

  
  // The recursive version. We break this up into two cases so users don't need to think about
  // min, max, and mid to use this function!

  def intArrayBinarySearch(data : Array[Int], item : Int) =
    intArrayBinarySearchRange(data, 0, data.length-1, item)

  def intArrayBinarySearchRange(data : Array[Int], min : Int, max : Int, item : Int) : SearchOutcome = {
    val mid = (min + max) / 2
    if (min > max) 
       SearchOutcome(false, -1)
    else if (item == data(mid))
       SearchOutcome(true, mid)
    else if (item > data(mid))
       intArrayBinarySearchRange(data, mid+1, max, item)
    else 
       intArrayBinarySearchRange(data, min, mid-1, item)
  }
}
