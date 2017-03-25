/**
  * Created by mgupta on 1/31/17.
  */
object Lab1 extends App {

  val a = 6 * 7
  a
  val b: BigInt = 21
  b.pow(1000)

  // Can import anywhere
  import scala.math._

  sqrt(10) * sqrt(10)
  val prime = BigInt.probablePrime(100, scala.util.Random)

  prime.toString(36).take(1)
  prime.toString(36).take(10000)
  prime.toString(36).takeRight(1)
  prime.toString(36).drop(5)

  //2 max 10

  1.to(10)

  // Apply sqrt to all numbers in the range
  println(1.to(10).map(sqrt(_)))

  6.*(7) // 42

  "Mississippi".distinct // Misp
  println("Rhine".permutations.toArray.mkString(" "))

  "ABC".sum // Char AE, same as ('A' + 'B' + 'C').toChar
  'A' + 'B' + 'C' // Int = 198 // same as "ABC".sum.toInt

  var l = 1L;
  for (c <- "Hello") l = l * c.toInt

  /*def product(str:String) : Long = {
    var l = 1L;
    for (c <- str) l = l * c.toInt
    l
  }*/



  def product(str:String) : Long = {
    if (str.length == 0) 1
    else str.head * product(str.tail)
  }

  println(product("hello"))



}
