val wlist = List("alpha", "gamma", "beta", "epsilon")
val tlist = wlist map { n => (n, n.length) }

val sortedBy1 = tlist.sortWith( (l, r) => l._1 < r._1)

println("sorted by component 1")
sortedBy1 foreach println

// Trying to sort on field _2 causes Scala compiler to tank. Yikes.

val sortedBy2 = tlist.sortWith( (l, r) => l._2 < r._2)
println("sorted by component 2")
sortedBy2 foreach println
