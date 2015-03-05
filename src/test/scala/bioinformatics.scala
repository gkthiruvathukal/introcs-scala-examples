import org.scalatest._

import bioinformatics._

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

  "Compeau and Pevzner (p146)" should "have correct adjacency list" in {
    val f = fixture
    val m = deBrujinAdjacency(f.seq, f.len)
    m("TA").length should be (1)
    m("AA").length should be (1)
    m("AT").length should be (3)
    m("TG").length should be (3)
    m("GC").length should be (1)
    m("CC").length should be (1)
    m("CA").length should be (1)
    m("GG").length should be (2)
    m("GA").length should be (1)
    m("GT").length should be (1)
    // m("TT").length should be (0)
  }

  it should "have correct corresponding matrix representation" in {
    val f = fixture
    val a = deBrujinAdjacency(f.seq, f.len)
    val m = getAdjacencyMatrix(a)
    m("TA")("AA") should be (1)
    m("AA")("AT") should be (1)
    m("AT")("TG") should be (3)
    m("TG")("GC") should be (1)
    m("GC")("CC") should be (1)
    m("CC")("CA") should be (1)
    m("CA")("AT") should be (1)
    m("GG")("GG") should be (1)
    m("GG")("GA") should be (1)
    m("GA")("AT") should be (1)
    m("GT")("TT") should be (1)
  }
}

