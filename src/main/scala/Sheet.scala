import scala.math._

/**
  * Created by mgupta on 1/28/17.
  */
object Sheet extends App {

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

  "Hello".intersect("World") // Yields "lo"
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
  "Hello".apply(4) // Same as "Hello"(4)
  val distance = {
    val dx = x0 - x1
    val dy = y0 - y1
    sqrt(dx * dx + dy * dy)
  }
  // Var is mutable
  var response = 54
  if (z > 0) "something" else -1 // Type is Any, Any = something

  z = -1
  if (z > 0) "something" // Any = ()
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


}
