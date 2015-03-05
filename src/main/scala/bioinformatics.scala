import scala.collection.mutable
import scala.util.Try
import scala.collection.mutable.{ HashMap, MutableList }

package object bioinformatics {

  def composition(seq: String, kmerLength: Int): IndexedSeq[String] = {
    require (kmerLength > 0)
    require (seq.length > kmerLength)
    0 to seq.length - kmerLength map { index => seq.substring(index, index + kmerLength) }
  }

  def prefix(s: String): String = {
    require (s.length > 0)
    s.substring(0, s.length - 1)
  }

  def suffix(s: String): String = {
    require (s.length > 0)
    s.substring(1)
  }

  def deBrujinAdjacency(seq: String, kmerLength: Int): Map[String, IndexedSeq[String]] = {
    composition(seq, kmerLength).groupBy(prefix)
  }

  def getAdjacencyMatrix(graph: Map[String, IndexedSeq[String]]): HashMap[String, HashMap[String, Int]] = {
    val rows = new HashMap[String, HashMap[String, Int]]()
    for (k <- graph.keys) {
      rows(k) = rows.getOrElse(k, new HashMap[String, Int]())
      for (kmer <- graph(k)) {
        val columns = rows(k)
        val nextNode = suffix(kmer)
        columns(nextNode) = columns.getOrElse(nextNode, 0) + 1
        // make sure all columns of the matrix also appear as rows
        rows(nextNode) = rows.getOrElse(nextNode, new HashMap[String, Int]())
      }
    }
    rows
  }

  def printMatrix(matrix: HashMap[String, HashMap[String, Int]]) = {
    for (row <- matrix.keys) {
      print(s"$row:")
      for (column <- matrix(row).keys) {
        print(s" $column/${matrix(row)(column)}")
      }
      println()
    }
  }

  def walkPath(graph: Map[String, IndexedSeq[String]], initialNode: String): List[String] = {
    var node = initialNode
    val path = MutableList[String]()
    val sparseMatrix = getAdjacencyMatrix(graph)
    var done: Boolean = false
    //println(s"start node = $node")
    while (!done) {
      path += node
      val innerMap = sparseMatrix(node)
      val candidates = innerMap.filter { case (seq, count) => count > 0 }

      val candidateNodes = candidates.keys
      if (candidateNodes.size == 0)
        done = true
      else {
        val nextNode = candidateNodes.head
        sparseMatrix(node)(nextNode) -= 1
        //print("visiting " + nextNode)
        //println(s" ... bumping adjacency matrix ($node,$nextNode) visited count " + sparseMatrix(node)(nextNode))
        node = nextNode
      }
    }
    path.toList
  }

  def main(args: Array[String]) {
    val DNA = "TAATGCCATGGGATGTT"
    val KMER_LENGTH = 3
    val dna = Try(args(0)).getOrElse(DNA)
    val kmerLength = Try(args(1).toInt).getOrElse(KMER_LENGTH)
    val kmers = composition(dna, kmerLength)
    val kmersInLexOrder = kmers.sorted
    println(s"dna: $dna")
    println(s"length: $kmerLength")
    println("kmers: " + kmers.mkString(" "))
    println("kmers (sorted): " + kmersInLexOrder.mkString(" "))
    println("adjacency list")
    val adjacencyList = deBrujinAdjacency(dna, kmerLength)
    adjacencyList map { case (k, v) => k + ": " + v.toList.mkString(", ") } foreach println

    val adjacencyMatrix = getAdjacencyMatrix(adjacencyList)
    printMatrix(adjacencyMatrix)
    println("walk path")
    val path = walkPath(adjacencyList, prefix(kmers(0)))
    for (i <- 0 until path.length) {
      println(" " * i + path(i))
    }
    println(dna)
  }
}

