// Inheritance

// As in java a class can be declared final so that it is not extended.
// Methods can be declared final as well so they are not overridden.
class Person {
  val name = "person";

  // In Scala, use 'override' modifier when you override a method that isn't abstract
  override def toString = s"${getClass.getName}[name=$name]"
}

class Employee extends Person {
  val salary = 1000

  override def toString = s"${super.toString}[salary=$salary]"
}

class Manager extends Employee

val e = new Employee
val p = new Person
val m = new Manager
e.toString // String = Employee[name=person][salary=1000]

// Use isInstanceOf to test whether an object belongs to a given class
// Use asInstanceOf to convert a reference to a subclass
p.isInstanceOf[Employee] // false
e.isInstanceOf[Employee] // true
m.isInstanceOf[Employee] // true

p.getClass == classOf[Employee] // No
e.getClass == classOf[Employee] // Yes
m.getClass == classOf[Employee] // No

if (m.isInstanceOf[Employee]) {
  val s = m.asInstanceOf[Employee] // s has type Employee
}

// As in Java, you can declare any field or method as protected, which can be accessed in subclass

// A class has one primary constructor and any number of auxiliary constructors
// All auxiliary constructors must start with call to a preceding auxiliary constructor or the primary constructor.
// As a consequence, an auxiliary constructor eventually call primary constructor of subclass and only primary constructor call superclass constructor.

class Person2(name: String, age: Int)

// As primary constructor is intertwined with the class def, so is call to super class constructor
class Employee2(name: String, age: Int, val salary: Double) extends Person2(name, age)

// Can also use pattern matching for type check and casts
p match {
  case s: Employee => println("Employee")
  case _ => println("Not Employee")
}

class Parent(val name: String, val age: Int)

class Child(name: String, age: Int, val gender: String) extends Parent(name, age)

val child = new Child("kid", 3, "female")

abstract class ABC {
  def id: Int // Each person has an ID that is computed in some way (id is abstract method)
}

class DEF(override val id: Int) extends ABC

// A def can only override another def
// A val can only override another val or a parameter-less def
// A var can only override an abstract var

class Human(val name: String) {
  override def toString = s"${getClass.getName}[name=$name]"
}

class SecretAgent(codename: String) extends Human(codename) {
  override val name = "secret" // override field
  override val toString = "secret" // override def
}

// ***

abstract class Student {
  def id: Int
}

class Friend(override val id: Int) extends Student // val override def

// Anonymous Subclass, defined by block in {}
val alien = new Human("Fred") {
  def greeting = s"Greetings!. My name is $name"
}

// As in Java, abstract keyword is used to donate a class that cannot be instantiated usually becasue one or more methods are not defined

abstract class XYZ(val name: String) {
  def id: Int
}

class PQR(name: String) extends XYZ(name) {
  def id = name.hashCode // override keyword is not required
}

// Abstract Fields

abstract class foo {
  val id: Int // abstract field with an abstract getter method. val doesn't have setter
  var name: String // abstract field with abstract getter and setter methods
}

class bar(val id: Int) extends foo {
  var name = ""
}

// customize abstract field by using anonymous type
val bar2 = new bar(55) {
  override var name = "Fred"
}

// Construction Order

class Creature {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature {
  override val range = 2
}

// Order
// The Ant constructor calls the creature constructor before doing its own construction
// the range is overridden in Ant so env calls range and sets range to 0
// Ant sets the range to 2
// Do Not Rely on value of val in body of constructor

// Solution
// Declare val as final
// Declare val as lazy in superclass
// Use early definition syntax in the subclass, lets you initialize val fields of a subclass before the superclass
class Ant2 extends {
  override val range = 2
} with Creature

// Object Equality

class Item(val description: String, val price: Double) {

  /*final override def equals(other:Any) = {
    other.isInstanceOf[Item] && {
      val that = other.asInstanceOf[Item]
      description == that.description && price == that.price
    }
  }*/

  final override def equals(other: Any) = other match {
    case that: Item => description == that.description && price == that.price
    case _ => false
  }
}

// Value Classes

// class extends AnyVal
// primary constructor has exactly one val parameter
// class has no other fields or constructors
// automatically provide equals and hashcode methods

class MilTime(val time: Int) extends AnyVal {
  def minutes = time % 100

  def hours = time / 100

  override def toString = f"$time%d"
}

val lunch = new MilTime(1230)
lunch.hours

// lunch * 2 // Error


// For proper initialization, make the primary constructor private and provide a factory method in the companion object
class MilTime2 private(val time: Int) extends AnyVal

object MilTime2 {

  def apply(t: Int) =

    if (0 <= t && t < 2400 && t % 100 < 60) new MilTime(t)

    else throw new IllegalArgumentException

}





