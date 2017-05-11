
// Without loops
val zones = java.util.TimeZone.getAvailableIDs
zones.map(s => s.split("/")).filter(_.length > 1).map(_ (1)).grouped(10).toArray.map(a => a(1))

// Reduction
(1 to 10).reduceLeft(_ * _)
def fact(n: Int) = 1.to(n).reduceLeft(_ * _)
fact(5)

1.to(5).map(n => 2).reduceLeft(_ * _)

def pow(a: Int, b: Int) = 1.to(b).map(n => a).reduceLeft(_ * _)
pow(2, 10)

def concat(strs: Seq[String], seprator: String) = strs.reduceLeft(_ + seprator + _)
concat(Array("Marry", "had", "a", "lamb"), " ")

// Do-It-yourself while