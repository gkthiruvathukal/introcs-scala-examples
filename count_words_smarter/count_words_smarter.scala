object CountWordsSmarter {
  def main(args: Array[String]) {
    val ignoreAll = "a an and the".split(" ")
    val ignore = ignoreAll.toSet
    val gettysburg = """
                       |Four score and seven years ago our
                       |fathers brought forth on this continent
                       |a new nation, conceived in liberty, and
                       |dedicated to the proposition that all
                       |men are created equal.
                       |
                       |Now we are engaged in a great civil
                       |war, testing whether that nation, or
                       |any nation, so conceived and so
                       |dedicated, can long endure.  We are met
                       |on a great battle-field of that war.
                       |We have come to dedicate a portion of
                       |that field, as a final resting place
                       |for those who here gave their lives
                       |that that nation might live.  It is
                       |altogether fitting and proper that we
                       |should do this.
                       |
                       |But, in a larger sense, we can not
                       |dedicate, we can not consecrate, we can
                       |not hallow this ground. The brave men,
                       |living and dead, who struggled here,
                       |have consecrated it, far above our poor
                       |power to add or detract. The world will
                       |little note, nor long remember what we
                       |say here, but it can never forget what
                       |they did here.  It is for us the
                       |living, rather, to be dedicated here to
                       |the unfinished work which they who
                       |fought here have thus far so nobly
                       |advanced.  It is rather for us to be
                       |here dedicated to the great task
                       |remaining before us—that from these
                       |honored dead we take increased devotion
                       |to that cause for which they gave the
                       |last full measure of devotion—that we
                       |here highly resolve that these dead
                       |shall not have died in vain—that this
                       |nation, under God, shall have a new
                       |birth of freedom—and that government
                       |of the people, by the people, for the
                       |people, shall not perish from the earth.
                     """.stripMargin('|')
    println(gettysburg)
    val wc = getCounts(gettysburg, ignore)
    printCounts(wc, 3)
  }

  // Return a Dictionary of word:count pairs from parsing s,
  //  excluding all strings in ignore. 

  def getCounts(s: String, ignore: Set[String]): Map[String, Int] = {
    val wordPattern = """(\w+)""".r
    val words = wordPattern.findAllIn(s.toLowerCase).toList

    // This maps words to word -> List(n * word)
    val wordsMap = words.groupBy(w => w)

    // exclude keys that are noise words
    val filteredKeys = wordsMap.keys.filter(n => !ignore.contains(n))

    // generate pairs (word, occurrences of word)
    val wordCountPairs = filteredKeys.map { a => (a, wordsMap(a).length)}

    // turn this into a proper map, mainly for final printing
    wordCountPairs.toMap
  }

  /// Print each word and its count, if the count is at least minCount.
  def printCounts(wc: Map[String, Int], minCount: Int) {
    val words = wc.keys.toList.sorted
    for (w <- words) {
      if (wc(w) >= minCount) {
        val count = wc(w)
        println(s"$w: $count")
      }
    }
  }
}
