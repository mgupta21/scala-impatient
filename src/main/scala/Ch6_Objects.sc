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
