import java.time.Instant
// LAB 4
// CLASSES

// Fields in classes automatically comes with getters and setters but can be replaced with custom methods
// Every class has a primary constructor that is 'interwoven' with the class definition. Its parameters turn into fields.

class Counter {
  private var value = 0

  def increment() { // Methods are public by default, () is optional
    value += 1
  }

  def current = value // () not used as a practice for non-mutator method
}

val myCounter = new Counter
myCounter.increment() // Good practice to use () with mutator methods
myCounter.current

class Person {
  var age = 0 // JVM automatically creates private age field and public getter and setters
}

val fred = new Person
fred.age // Calls public method fred.age()
fred.age = 21 // Calls public setter method fred.age_=(21)

// You can give custom getter / setter
class PrivatePerson {
  private var privateAge = 0

  def age = privateAge

  def age_=(newAge: Int): Unit = {
    if (newAge > privateAge) privateAge = newAge; // Can't get younger
  }

}

class Message {
  val timeStamp = Instant.now // JVM generates private final field, public getter method and no setter for val field
}

// To set a field that client can't change but other methods can, declare var field private
class CounterB {
  private var value = 0

  def increment() {
    value += 1
  }

  def current = value // No () in declaration
}

// As in java, a method can access the private fields of all objects of its class
class CounterC {
  private var value = 0
  private[this] var value2 = 0 // other.value2 is not allowed

  def increment() {
    value += 1
  }

  def isLess(other: CounterC) = value < other.value

  // def isMore(other: CounterC) = value2 > other.value2
}

// Scala provides 2 constructors the Primary constructor is more important than Auxiliary
// Auxiliary Constructors
// 1. Auxiliary Constructors are called this(unlike in java where constructors have same name as class)
// 2. Auxiliary Constructor must start with a call to a previously defined auxiliary constructor

class PersonB {
  private var name = ""
  private var age = 0

  def this(name: String) {
    this() // Calls primary constructor
  }

  def this(name: String, age: Int) {
    this(name) // Calls previous auxiliary constructor
    this.age = age
  }
}

val p1 = new PersonB // Using primary constructor
val p2 = new PersonB("Fred") // Using first auxiliary constructor
val p3 = new PersonB("Fred", 22) // Using second auxiliary constructor

// Primary Constructor
// The primary constructor is not defined but is interwoven with the class definition
// The parameters of primary constructor are placed immediately after the class name
class PersonC(val name: String, val age: Int) // Primary constructor with 2 arguments
class something // Primary constructor with no arguments

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

// Objects
// In scala use object for singletons, static methods or fields, no static keyword scala.
// Constructor of an object is executed when the object is first used.
// Objects can have all features of a class, and can extend a Class or Trait

object Account {
  private var lastNumber = 0

  def newUniqueNumber() = {
    lastNumber += 1;
    lastNumber
  }
}

println(Account.newUniqueNumber()) // 1 // method is invoked like static methods in java
println(Account.newUniqueNumber())

// 2

// An Object extending App is like main in java
/*object MyApp extends App {
  println(f"Hello, ${args(0)}")
}*/

// In java a class can have both instance and static methods. In scala, this can be achieved by having a class adn a companion object
// "Companion object" of class = object with the same name in the same source file
// Have access to private features of each other, must be located in the same file

class Account {
  val id = Account.newUniqueNumber()
  private var balance = 0.0

  def deposit(amount: Double) {
    balance += amount;
  }
}

// Usage : common to have apply in companion object. Typically apply method returns an object of the companion class
object Point {
  def apply(x: Double, y: Double) = new Point(x, y)
}

// With companion object client doesn't need to call new
//val p3 = Point(3, 4) * 3

// scala does not have a enumeration type, use Enumeration helper class to produce enumerations
object TrafficLightColor extends Enumeration {
  val Red, Yellow, Green = Value
}

object TrafficColor extends Enumeration {
  val Red = Value(0, "Stop") // ID 0, Name "Stop"
  val Yellow = Value(10) // Name = "Yellow"
  val Green = Value("Go") // ID 11
}

for (c <- TrafficColor.values) println(s"${c.id}:$c")
for (c <- TrafficLightColor.values) println(s"${c.id}:$c")


// LAB 5
// PACKAGES

//import java.awt.{Color, Font} // import 2 classes
//import java.util.{HashMap => JavaHashMap} // alias
//import java.util.{HashMap => _,_} // hide a class
