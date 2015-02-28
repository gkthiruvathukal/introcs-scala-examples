import scala.math.min
import scala.io._
import scala.util._

object arraylab {

  def arraySize(a: Array[Int]): Int = {
    /*
     * Returns the length of the array.
     *
     * No need to change this method. It already does its job!
     * The intention is to show one function that passes tests.
     */
    a.length
  }

  def getIntsAsString(label: String, delimiter: String, a: Array[Int]): String = {
    /*
     * This function will convert the array (a) to a string representation. 
     * By way of example:
     *   getIntsAsString("My Array is: ",", ", Array(1, 3, 5)) gives
     *     "My array is: 1,3,5"
     *   getIntsAsString("My Array = ", ":", Array(2, 4, 6)) gives
     *     "My Array = 2:4:6"
     */


    val aAsString = "" // your job: compute aAsString

    // You need to delete the line below and replace with code to do what is being asked.
    label + aAsString
  }

  def readFileIntoArray(filename: String, a: Array[Int]) {
    /*
     * Open a file for input. Using a simple for loop, read the lines of the
     * file into the array a. If a line does not contain a valid integer, use 0
     * for that line. See the files ints.txt and input.txt. These files are
     * read automatically when running the tests on your code.
     */

   for (file <- Try(Source.fromFile(filename)).toOption) {
     // put your code in here to read lines into a
   }
  }

  def minimum(a: Array[Int]): Int = {
    /*
     * This require() is needed for the test for 0 length to pass.
     */
    require(a.length > 0)

    // Your code here. Be sure to delete Int.MinValue.
 
    Int.MinValue
  }

  def countEven(a: Array[Int]): Int = {
    /*
     * Returns a count of the number of even integers in the array.
     */

    // Your code here. Be sure to delete Int.MinValue.

    Int.MinValue
  }

  def countOdd(a: Array[Int]): Int = {
    /*
     * Returns a count of the number of even integers in the array.
     */

    Int.MinValue
  }

  def pairwiseAdd(a: Array[Int], b: Array[Int], c: Array[Int]) : Unit = {
    require(c.length >= min(a.length, b.length))
    /*
     * Modifies an incoming array c, where c(i) = a(i) + b(i).
     * If a.length and b.length are not equal, find the smaller
     * of the two, k=min(a.length, b.length) and sum up the 
     * elements from 0 to k.
     *
     * Returns Unit, meaning that you don't have to explicitly return anything.
     */

 
  }
  def newPairwiseAdd(a: Array[Int], b: Array[Int]): Array[Int] = {
    val addSize = min(a.length, b.length)
    val newArray = Array.fill(addSize)(0)

    /*
     * Hint: You can probably get pairwiseAdd() to do the work of 
     * this function!
     */

    // Your code here.

    // You will want to return newArray here (leave as is).
    newArray
  }
  def isAscending(a: Array[Int]): Boolean = {

    /*
     * Returns true if each element of array a is the same or increasing
     * in value.
     */

    // Delete this after putting your code above.
    false
  }

  def getAscendingRun(a: Array[Int], position: Int): Int = {
    require(position < a.length)
    /*
     * Returns the position of the first value found in a that is not
     * the same or increasing. For example:
     * 
     * getAscendingRun(Array(1, 2, 3, 1, 2, 3, 2, 3), 0) returns 3
     * getAscendingRun(Array(1, 2, 3, 1, 2, 3, 2, 3), 3) returns 6
     * getAscendingRun(Array(1, 2, 3, 1, 2, 3, 2, 3), 6) returns 8
     */

    // replace with your code, which should return Int
    -1
  }

 
  def getRunsAsString(a: Array[Int]): String = {
    /*
     * Returns a string that shows the runs. The integers are separated by "," and each
     * run is separated by "|".
     * 
     * getRunsAsString(Array(1, 2, 3, 1, 2, 3, 2, 3) returns
     *   "1, 2, 3 | 1, 2, 3 | 2, 3"
     * getRunsAsString(Array(1, 2, 2, 3, 1, 2, 1, 2, 3, 1) returns
     *   "1, 2, 2, 3 | 1, 2 | 1, 2, 3 | 1"
     */

    // replace with your code
    "" 
  }
}
