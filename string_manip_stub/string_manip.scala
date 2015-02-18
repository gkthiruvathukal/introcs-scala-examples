object StringManip {
  def main(args: Array[String]) {
    val str1 = "It was the best of times."
    val str2 = "Of times it was the best."
    println("str1=" + str1)
    println("str2=" + str2)
    println()
    // to embed a quote inside a string constant, precede it by backslash(\).
    println("Let us do some \"cutting and pasting\" of strings!")
    val str3 = replaceFirst(str1, "best", "worst")
    println("str3 = str1 with best => worst: " + str3)
    val str4 = replaceFirst(str2, "best", "worst")
    println("str2 with best => worst: " + str4)
    val str5 = replaceFirst(str3, "worst", "best")
    println("str3 with worst => best: " + str5)
    // Put code here
  }
  // end main chunk  
  /// Return s with the first occurence of target
  /// replaced by replacement.
  def replaceFirst(s: String, target: String, replacement: String) =
    {
      "Not implemented"; // so it compiles
    }

  /// Most concrete version:
  /// Assume s is "It was the best of times"
  /// target is "best"
  /// replacement is "worst"
  def replaceFirst1(s: String, target: String, replacement: String) =

    {
      // here totally concrete, but you still must 
      // understand what is being asked:
      // want string "It was the worst of times." and
      // it is returned!
      "It was the worst of times";
    }

  // Rather than jump to the most general s, which varies in
  // content, length, and placement of the target,
  // assume the target is best, and in the same place, but you do not
  // know what the other characters are ahead of time:
  // s is "???????????best??????????"
  //       0123456789012345678901234
  def replaceFirst2(s: String, target: String, replacement: String) =
    { /* plan:
        
        */
      "Not implemented"; // so it compiles
    }

  /*
    In another version you might assume the target was best, 
    it could be at a different place in the string.
    Finally you would make the generalization the that the target
    could be anything, with any length, and get the next version.
    */

  /// Return s with the first occurence of target
  ///  replaced by replacement.  As far as we got,
  ///  the target is ASSUMED to be in s.
  def replaceFirst3(s: String, target: String, replacement: String) =
    { // code in class! ASSUME target appears in s
      "Not implemented"; // so it compiles
    }

  // The truly final version would probably allow for the target
  // to not be in s:
}