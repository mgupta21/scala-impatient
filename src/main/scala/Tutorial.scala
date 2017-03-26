import scala.math._

/**
  * Created by mgupta on 1/28/17.
  */
object Tutorial extends App {

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
  val b = ArrayBuffer("Mary", "had", "a", "little", "lamb")
  b(0) = "Stacy"
  b += "its" // append element to end
  b += ("fleece", "was", "white") // append collection to end
  b ++= Array("as", "snow") // append Array to end
  println(b)

  b.remove(3)
  println(b)

  b.insert(3, "small")
  println(b)

  b.trimEnd(2) // Trims last 2 elements
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

  // LAB 4
  // CLASSES

  // if fields are val, they cannot be mutated. When defined fields automatically gives rise to a constructor
  class Point(val x: Double = 0, val y: Double = 0) {
    def move(dx: Double, dy: Double) = new Point(x + dx, y + dy)

    def distanceFromOrigin = Math.sqrt(x * x + y * y)

    // Identifiers(method names etc.) can be symbols
    def *(factor: Double) = new Point(x * factor, y * factor)

    override def toString = f"(${x}, ${y})" //f represents formatter

  }

  var p = new Point(3, 4);
  p.x
  p.y

  // p.x = 13 // cannot mutate val

  p.distanceFromOrigin // no parenthesis required in method call
  p.*(2)
  p * 2 // same as p.*(2)
  p = p.move(10, 20) // returns new point, not mutable
  println(p)

  var p2 = new Point(); // Creates with x, y with default value, if default values were not provided then empty constructor cannot be invoked

  1 to 10 map (3 * _) filter (_ % 5 == 2)
  1.to(10).map(3 * _).filter(_ % 5 == 2)

  // Use object for singletons, static methods
  object Accounts {
    private var lastNumber = 0

    def newUniqueNumber() = {
      lastNumber += 1;
      lastNumber
    }
  }

  println(Accounts.newUniqueNumber()) // 1
  println(Accounts.newUniqueNumber())

  // 2

  // An Object extending App is like main in java
  /*object MyApp extends App {
    println(f"Hello, ${args(0)}")
  }*/

  // "Companion object" of class = object with the same name in the same source file
  // Have access to private features of each other
  // Usage : common to have apply in companion object for factory methods
  object Point {
    def apply(x: Double, y: Double) = new Point(x, y)
  }

  // With companion object client doesn't need to call new
  //val p3 = Point(3, 4) * 3


  // LAB 5
  // PACKAGES

  //import java.awt.{Color, Font} // import 2 classes
  //import java.util.{HashMap => JavaHashMap} // alias
  //import java.util.{HashMap => _,_} // hide a class

  // Inheritance
  class Person(name: String, age: Int)

  // super class construction
  class Employee(name: String, age: Int, val salary: Double) extends Person(name, age)

  class Manager(name: String, age: Int, salary: Double, val level: String) extends Employee(name, age, salary)

  val manager = new Manager("", 0, 0, "")
  manager.isInstanceOf[Manager] // like manager instanceOf Manager
  manager.asInstanceOf[Manager] // like (Manager) manager
  manager.getClass == classOf[Manager]

  // like Manager.class

  // Traits - superficially similar to java interface
  // A class can extend multiple traits
  class Employee2(name: String, age: Int, val salary: Double) extends Person(name, age) with Cloneable with Serializable

  // Traits can have abstract and concrete fields
  // Traits cannot have construction parameters. Technically, that's the only difference between class and trait

  // Use traits to "mix in" small amounts of functionality
  // can also mix into objects

  trait Logged {
    def log(msg: String) {}
  }

  trait ConsoleLogger extends Logged {
    override def log(msg: String) {
      println(msg)
    }
  }

  trait TimestampLogger extends Logged {
    override def log(msg: String): Unit = {
      super.log(new java.util.Date() + " " + msg)
    }
  }

  trait ShortLogger extends Logged {
    val maxLength = 15;

    override def log(msg: String): Unit = {
      super.log(if (msg.length < maxLength) msg
      else msg.substring(0, maxLength - 3) + ".....")
    }
  }

  class SavingsAccount extends Logged {
    private var balance: Double = 0

    def withdraw(amount: Double): Unit = {
      if (amount > balance) log("Insufficient Balance")
      else balance -= amount;
    }

  }

  val acc = new SavingsAccount with ConsoleLogger

  // traits are applied in reverse order
  val acc2 = new SavingsAccount with ConsoleLogger with TimestampLogger with ShortLogger

  acc.withdraw(1000)
  acc2.withdraw(1000)

  val acc3 = new SavingsAccount with ConsoleLogger with TimestampLogger with ShortLogger {
    override val maxLength = 20
  }

  acc3.withdraw(1000)

  val acc4 = new SavingsAccount with ShortLogger with TimestampLogger with ConsoleLogger // order is important
  acc4.withdraw(1000)

}