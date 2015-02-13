val wlist = List("alpha", "gamma", "beta", "epsilon")
case class DerivedData(s : String, len : Int)
val tlist = wlist map { n => DerivedData(n, n.length) }


val sortedBy1 = tlist.sortWith( (l, r) => l.s < r.s)

println("sorted by component 1")
sortedBy1 foreach println

val sortedBy2 = tlist.sortWith( (l, r) => l.len < r.len)
println("sorted by component 2")
sortedBy2 foreach println
