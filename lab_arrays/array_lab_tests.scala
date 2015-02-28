
import org.scalatest._
import arraylab._
import scala.util.{ Try, Success, Failure }

class RationalScalaTestFlatSpecMatchers extends FlatSpec with Matchers {

  "getIntsAsString()" should "handle empty array" in {
    val result = getIntsAsString("label1: ", ":", Array[Int]())
    result should be ("label1: ")
  }

  it should "handle non-empty array" in {
    val result = getIntsAsString("label2: ", ":", Array[Int](1, 2, 3))
    result should be ("label2: 1:2:3")
  }

  it should "handle different labels" in {
    val result = getIntsAsString("label2: ", ":", Array[Int](1, 2, 3))
    result should be ("label2: 1:2:3")
  }

  "minimum()" should "not work for 0-length array" in {
    intercept[IllegalArgumentException] {
      val minValue = minimum(Array[Int]())
    }
  }

  it should "work for a >0-length array" in {
    val minValue = minimum(Array(5, 10, 2, 4, 8, 6, -1, -3))
    minValue should be (-3)
  }

  "readFileIntoArray()" should "read all of ints.txt" in {
    // This is creating an array of 7 Ints, items initialized to 0
    val data = Array.fill(7)(0)
    readFileIntoArray("ints.txt", data)
    data should be (Array(25, 35, 50, 75, 10, -11, 55))
  }

  it should "read first 5 lines of ints.txt" in {
    // This is creating an array of 5 Ints, items initialized to 0
    val data = Array.fill(5)(0)
    readFileIntoArray("ints.txt", data)
    data should be (Array(25, 35, 50, 75, 10))
  }

  "countEven()" should "count these even items" in {
    val data = (1 to 10).toArray
    val numberEven = countEven(data)
    numberEven should be (5)
  }

  it should "count zero for an empty array" in {
    countEven(Array[Int]()) should be (0)
  }

  "countOdd()" should "count these odd items" in {
    val data1 = (1 to 10).toArray
    val numberOdd1 = countOdd(data1)
    numberOdd1 should be (5)
    val data2 = (1 to 50).toArray
    val numberOdd2 = countOdd(data2)
    numberOdd2 should be (25)
  }

  it should "count zero for an empty array" in {
    countOdd(Array[Int]()) should be (0)
  }

  "pairwiseAdd()" should "add corresponding elements of arrays" in {
    val a = Array(1, 2, 4, 6, 8, 10)
    val b = Array(1, 2, 4, 6, 8, 10, 13)
    val result = Array.fill(6)(0)
    pairwiseAdd(a, b, result)
    result should be (Array(2, 4, 8, 12, 16, 20))
  }

  "newPairwiseAdd()" should "add corresponding elements of arrays" in {
    val a = Array(1, 2, 4, 6, 8, 10, 13, 15)
    val b = Array(1, 2, 4, 6, 8, 10, 13)
    val result = newPairwiseAdd(a, b)
    result should be (Array(2, 4, 8, 12, 16, 20, 26))
  }

  "isAscending()" should "work with this data" in {
    val ascendingData1 = Array(1, 10, 100, 1000, 10000, 1000000)
    val ascendingData2 = Array(1, 5, 10, 50, 100, 500, 1000, 7500, 8500, 10000, 1000000)
    isAscending(ascendingData1) should be (true)
    isAscending(ascendingData2) should be (true)
  }

  it should "not work with this data" in {
    val nonAscendingData1 = Array(1, 10, 100, 99, 10000, 9999, 1000000)
    val nonAscendingData2 = Array(1, 5, 10, 50, 49, 100, 500, 499, 1000, 7500, 8500, 10000, 1000000)
    isAscending(nonAscendingData1) should be (false)
    isAscending(nonAscendingData2) should be (false)
  }

  "getAscendingRuns()" should "work with the provided example" in {
    val a = Array(2, 5, 8, 3, 9, 9, 8)
    getAscendingRun(a, 0) should be (3)
    getAscendingRun(a, 3) should be (6)
    getAscendingRun(a, 6) should be (7)
  }

  it should "also work with different data" in {
    val a = Array(2, 5, 8, 3, 9, 9, 8, 3, 3, 4, 4, 5, 5, 6, 6)
    getAscendingRun(a, 0) should be (3)
    getAscendingRun(a, 3) should be (6)
    getAscendingRun(a, 6) should be (7)
    getAscendingRun(a, 7) should be (15)
  }

  "getRunsAsString()" should "work with the provided example" in {
    val a = Array(2, 5, 8, 3, 9, 9, 8)
    getRunsAsString(a) should be ("2, 5, 8 | 3, 9, 9 | 8")
  }

  it should "also work with different data" in {
    val a = Array(2, 5, 8, 3, 9, 9, 8, 3, 3, 4, 4, 5, 5, 6, 6)
    getRunsAsString(a) should be ("2, 5, 8 | 3, 9, 9 | 8 | 3, 3, 4, 4, 5, 5, 6, 6")
  }
}

