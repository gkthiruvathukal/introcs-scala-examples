import scala.util.Try

object bioinformatics {

   def composition(seq : String, kmerLength : Int) = {
     require (kmerLength > 0)
     require (seq.length > kmerLength)
     0 to seq.length-kmerLength map {index => seq.substring(index, index+kmerLength) }
   }

   // Try running this program as follows:
   // usage: sbt "run-main kmers DNA-Sequence Length"
   // sbt "run-main kmers TATGGGGTGC 3"

   def prefix(s : String) : String = {
      require (s.length > 0)
      s.substring(0, s.length-1)
   }   

   def suffix(s : String) : String = {
      require (s.length > 0)
      s.substring(1)
   }

   def kmersWithPrefix( kmers : IndexedSeq[String], index : Int) = {
      (0 until kmers.length) filter { i => i != index && suffix(kmers(i)) == prefix(kmers(i)) }
   }

   def main(args : Array[String]) {
      val DNA = "TATGGGGTGC"
      val KMER_LENGTH = 3
      val dna = Try(args(0)).getOrElse(DNA)
      val kmerLength = Try(args(1).toInt).getOrElse(KMER_LENGTH)
      val kmers = composition(dna, kmerLength)
      val kmersInLexOrder = kmers.sorted
      println(s"kmers: " + kmers.mkString(" "))
      println(s"kmers (sorted lexicographically): " +  kmersInLexOrder.mkString(" "))
   }
}

