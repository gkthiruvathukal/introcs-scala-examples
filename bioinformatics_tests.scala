
import org.scalatest._
import bioinformatics._
import scala.util.{Try, Success, Failure}


class RationalScalaTestFlatSpecMatchers extends FlatSpec with Matchers {

  def fixture = new {
    val seq = "TAATGCCATGGGATGTT"
    val len = 3
    val expected = Vector("TAA", "AAT", "ATG", "TGC", "GCC", "CCA", 
      "CAT", "ATG", "TGG", "GGG", "GGA", "GAT", "ATG", "TGT", "GTT")    
  }

  "k-mer composition" should "handle Pevzner page 137" in {
    val f = fixture
    val kmers = composition(f.seq, f.len)
    kmers should be (f.expected)
  }

  "suffix(s)" should "fail for |s| = 0" in {
    intercept[IllegalArgumentException] {
      suffix("")
    }
  }
  it should "work for |s| > 0" in {
    suffix("TAT") should be("AT")
    suffix("T") should be ("")
    suffix("AT") should be ("T")
  }

  "prefix(s)" should "fail for |s| = 0" in {
    intercept[IllegalArgumentException] {
      prefix("")
    }
  }

  it should "work for |s| > 0" in {
    prefix("TAT") should be("TA")
    prefix("T") should be ("")
    prefix("AT") should be ("A")
  }

  "k-mers with suffix" should "not contain k-mer being compared" in {
    val f = fixture
    val kmers = composition(f.seq, f.len)
    val notFoundResults = 0 until kmers.length map { i => kmersWithPrefix(kmers, i).contains(i) } count { _ == false }
    notFoundResults should be (kmers.length)
  }
}
 
