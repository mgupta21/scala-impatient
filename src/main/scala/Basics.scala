import scala.math._

/**
  * Created by mgupta on 1/28/17.
  */
object Basics extends App {

  println("Welcome to the Scala worksheet")

  // Val is immutable
  val answer = 8 + 5
  // answer = 76  // Cannot reassign a val
  answer
  val x: BigInt = 12345678
  // Can reassign var
  response = 78
  val result = 1.+(10)
  greeting = "Hello"
  // In Scala, an expression has a value
  val exp = if (z > 0) 1 else -1 // Like x > 0 ? 1 : -1 in java

  // Everything is a object. Creating Range
  1.to(10)
  1 to 10

  "Hello".intersect("World")
  // Yields "lo"
  // Type of () is unit, Unit is equivalent to void in java but has one value denoted ()
  val y = () // Unit = ()
  x * x * x * x
  // Value of block is the value of the last statement
  val x0, y0, x1, y1 = 1
  result

  // ++, -- operators are not supported

  // INVOKE FUNCTIONS AND METHODS

  // Methods without parameters usually do not use (), () is only required for mutators
  "Hello".length

  "Hello" (4) // Yields 'o'
  "Hello".apply(4)
  // Same as "Hello"(4)
  val distance = {
    val dx = x0 - x1
    val dy = y0 - y1
    sqrt(dx * dx + dy * dy)
  }
  // Var is mutable
  var response = 54
  if (z > 0) "something" else -1 // Type is Any, Any = something

  z = -1
  if (z > 0) "something"
  // Any = ()
  var greeting: String = null
  var count: Int = 2
  var z = 1
  // If last expression is an assignment, the block value is ()
  var yy, i, n = 1
  while (yy > 0) {
    i += 1
    n = n / 2
    yy -= 1
  }

  // FOR

  // Scala doesn't have three part loop for (i =1; i <=n; i++)
  n = 10
  for (i <- 1 to n) println(i) // prints number 1, 2, 3 .....n
  for (c <- "hello") println(c) // h e l l o

  // Multiple generators
  println(for (i <- 1 to 3; j <- 1 to 3) print((10 * i + j) + " ")) // 11 12 13 21 22 23 31 32 33

  // Guards
  println(for (i <- 1 to 3; j <- 1 to 3 if i != j) print((10 * i + j) + " ")) // 12 13 21 23 31 32

  // Collecting results
  for (i <- 1 to 10) yield i % 3 // returns vector, similar to ArrayList in java

  // FUNCTIONS

  // To define a function, specify name, parameters and body
  def abs(x: Double) = if (x > 0) x else -x // Return type double is inferred

  // Return type is inferred unsless the function is recursive in which cas explicit return type is required
  def fac(n: Int): Int = if (n <= 0) 1 else n * fac(n - 1)

  // Or define return type Unit for Void method
  def box2(s: String): Unit = {
    box(s)
  }

  // If we omit =, the function doesn't return a value. Like void funciton in java
  def box(s: String) {
    val border = "-" * s.length + "--\n"
    println(border + "|" + s + "|\n" + border)
  }

  println(box("Mayank"))
  println(box2("Gupta"))

  // Scala supports named arguments, is useful for greater clarity
  // Scala also supports default arguments, lets to omit argument values
  def decorate(s: String, left: String = "[", right: String = "]") = left + s + right

  println(decorate("hello"))
  println(decorate("hello", ">>["))
  // Named argument
  println(decorate("hello", right = "]<<"))
  println(decorate("hello", ">>[", "]<<"))

  // Variable number of arguments indicated by *, representing Seq[Int]
  def sum(x: Int*) = {
    var result = 0
    for (i <- x) result += i
    result
  }

  println(sum(1, 2, 3))
  println(sum(1, 2, 3, 4, 5))

  // if you already have Seq[Int], need declaration to pass it
  // sum(1 to 10) // doesn't work
  sum(1 to 10: _*) // works // _ tells scala to consider something as Seq of something

  // declaration is also needed in recursive call
  def recSum(args: Int*): Int = {
    if (args.length == 0) 0
    else args.head + recSum(args.tail: _*)
  }

  println(recSum(1, 2, 3))

  // LAB 3
  // ARRAYS

  // Use square brackets for the type
  val nums = Array[Int](10)
  // Ten integers all initialized to 0
  // Initialize Array during declaration
  val a = Array("Hello", "World") // Type is inferred
  a(0) = "Goodbye" // Able to reassign val ?

  // Traverse
  for (e <- a) println(e)
  for (i <- 0 until a.length) println(a(i))

  val xN = new Array[Int](10)
  for (i <- 0 until xN.length) xN(i) = i * i
  for (e <- xN) println(e)

  // Use ArrayBuffer as analog for ArrayList in java
  import scala.collection.mutable.ArrayBuffer

  val a1 = new ArrayBuffer[Int]()
  var bX = ArrayBuffer("Mary", "had", "a", "little", "lamb")
  bX(0) = "Stacy"
  bX += "its" // append element to end
  bX += ("fleece", "was", "white") // append collection to end
  bX ++= Array("as", "snow") // append Array to end
  println(b)

  bX.remove(3)
  println(b)

  bX.insert(3, "small")
  println(b)

  bX.trimEnd(2) // Trims last 2 elements
  println(b)

  val a2 = Array(2, 3, 5, 7, 11)
  val a4 = for (elem <- a2) yield elem * 2
  println(a4.mkString("[", ", ", "]")) // 4 6 10 14 22

  Array(1, 7, 2, 9).sum // 19
  Array(1, 7, 2, 9).reverse // Array(9, 2, 7, 1)
  ArrayBuffer("Mary", "had", "a", "little", "lamb").max // "little"
  ArrayBuffer(1, 7, 2, 9).sorted // ArrayBuffer(1, 2, 7, 9)

  // MAPS
  // immutable map, by default scala maps are immutable
  val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
  val scores3 = scores + ("John" -> 2)
  // scores3 immutable map
  var scores4 = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
  scores4 = scores4 + ("Peter" -> 9)


  val scores2 = scala.collection.mutable.Map("Alice" -> 20)
  scores2("Alice") = 7
  scores2 += ("Bpb" -> 3, "Fred" -> 7)
  scores2 -= "Alice"
  "Alice" -> 20
  // pair
  val bobScore = scores("Bob") // 3

  //scores("Fred") // NoSuchElementException
  scores.getOrElse("Fred", 0) // 0

  for ((k, v) <- scores) println(k + " has value " + v)
  val revScores = for ((k, v) <- scores) yield (v, k) //immutable map

  scores.keySet
  scores.values

  // To implement "function call" notation, provide an apply method
  //scores.apply("bob") // same as
  //scores("bob")

  // TUPLE : Aggregates values of different types
  val t = (1, 3.14, "Fred")
  val first = t._1
  val (_, second, third) = t

  // second = 3.14, third = "Fred"

}