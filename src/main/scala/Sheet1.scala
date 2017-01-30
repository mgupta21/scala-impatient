/**
  * Created by mgupta on 1/28/17.
  */
object Sheet1 extends App {

  println("Welcome to the Scala worksheet")

  // Val is immutable
  val answer = 8 + 5
  // answer = 76  // Cannot reassign a val
  answer

  // Var is mutable
  var response = 54
  // Can reassign var
  response = 78

  var greeting: String = null
  greeting = "Hello"

  var count: Int = 2

  // Everything is a object. Creating Range
  1.to(10)
  1 to 10

  "Hello".intersect("World")  // Yields "lo"

  val x:BigInt = 12345678
  x*x*x*x

  val result = 1.+(10)
  result

  // ++, -- operators are not supported


}
