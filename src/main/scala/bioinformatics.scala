import scala.collection.mutable
import scala.util.Try
import scala.collection.mutable.{HashMap, MutableList}

package object bioinformatics {

  def composition(seq: String, kmerLength: Int)  : IndexedSeq[String] = {
    require (kmerLength > 0)
    require (seq.length > kmerLength)
    0 to seq.length - kmerLength map { index => seq.substring(index, index + kmerLength) }
  }

  // Try running this program as follows:
  // usage: sbt "run-main kmers DNA-Sequence Length"
  // sbt "run-main kmers TATGGGGTGC 3"

  def prefix(s: String): String = {
    require (s.length > 0)
    s.substring(0, s.length - 1)
  }

  def suffix(s: String): String = {
    require (s.length > 0)
    s.substring(1)
  }

  def deBrujinAdjacency(seq: String, kmerLength: Int) : Map[String, IndexedSeq[String]] = {
    composition(seq, kmerLength).groupBy(prefix)
  }

  def getSparseMatrix(graph : Map[String, IndexedSeq[String]]) : HashMap[String, HashMap[String, Int]] = {
    val hashMap = new HashMap[String, HashMap[String, Int]]()
    for (k <- graph.keys) {
      hashMap(k) = hashMap.getOrElse(k, new HashMap[String, Int]())
      for (kmer <- graph(k)) {
        val entryMap = hashMap(k)
        val nextNode = suffix(kmer)
        entryMap(nextNode) = entryMap.getOrElse(nextNode, 0) + 1
        // make sure all columns of the matrix also appear as rows!
        hashMap(nextNode) = hashMap.getOrElse(nextNode, new HashMap[String, Int]())
      }
    }
    hashMap
  }

  def euler( graph : Map[String, IndexedSeq[String]], initialNode : String): Unit = {
    var node = initialNode
    val path = MutableList[String]()
    val sparseMatrix = getSparseMatrix(graph)
    var done : Boolean = false
    println(s"start node = $node")
    while (!done) {
      path += node
      val innerMap = sparseMatrix(node)
      val candidates = innerMap.filter(p => p._2 > 0)

      val candidateNodes = candidates.keys.toArray
      if (candidateNodes.length == 0)
        done = true
      else {
        val nextNode = candidateNodes(0)
        sparseMatrix(node)(nextNode) -= 1
        println("visiting " + nextNode)
        node = nextNode
      }
    }
    path foreach println
  }

  def main(args: Array[String]) {
    val DNA = "TAATGCCATGGGATGTT"
    val KMER_LENGTH = 3
    val dna = Try(args(0)).getOrElse(DNA)
    val kmerLength = Try(args(1).toInt).getOrElse(KMER_LENGTH)
    val kmers = composition(dna, kmerLength)
    val kmersInLexOrder = kmers.sorted
    println(s"dna: $dna")
    println("kmers: " + kmers.mkString(" "))
    println("kmers (sorted lexicographically): " + kmersInLexOrder.mkString(" "))
    println("de Brujin Adjacency list")
    val adjacencyList = deBrujinAdjacency(dna, kmerLength)
    adjacencyList foreach println

    val sparseMatrix = getSparseMatrix(adjacencyList)
    println(sparseMatrix)
    println("Running Euler")
    euler(adjacencyList, prefix(kmers(0)))
  }
}

