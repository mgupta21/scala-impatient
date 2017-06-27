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

// The primary constructor executes all statements in the class definition.
class PersonD(val name: String, val age: Int) { // private fields with public getter / setters
  println("Just constructed another person") // executed whenever an object is constructed

  def description = s"$name is $age years old"
}

// Often auxiliary constructors can be eliminated by using default arguments in primary constructor
class PersonE(val name: String = "", val age: Int = 0)

// name has public getter /setter but age has private getter / setters
class PersonF(val name: String, private var age: Int) // val and var declares and initializes fields

// If a parameter without var or val is used inside at least one method, it becomes a field
class PersonG(name: String, age: Int) { // declares and initializes immutable fields that are object private
  def description = s"$name is $age years old"
}

class PersonH(name: String) {} // no field as no method uses name

// TODO : Nested Classes

// Videos
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

var pn = new Point(); // Creates with x, y with default value, if default values were not provided then empty constructor cannot be invoked

1 to 10 map (3 * _) filter (_ % 5 == 2)
1.to(10).map(3 * _).filter(_ % 5 == 2)