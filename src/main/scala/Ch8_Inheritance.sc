// As in Java, you can declare a class final so that it cannot be extended.
// You can also declare individual methods or fields final so that they cannot be overridden

class Person {
  //  You must use the override modifier when you override a method that isn’t abstract.
  var name = "person"

  override def toString = s"${getClass.getName}[name=$name]"

}

var person = new Person

class Employee extends Person {

  var salary = 100;

  override def toString = s"${super.toString}[salary=$salary]"

}

var employee = new Employee

if (employee.isInstanceOf[Person]) {
  val person2 = employee.asInstanceOf[Person] // person2 has type Person
  // person.asInstanceOf[Employee] // Class cast exception
  var emp2 = person2.asInstanceOf[Employee]
  if (person2.getClass == classOf[Employee]) {
    println("Is employee class")
  }
}

// Can also use pattern matching for type check and casts
person match {
  case s: Employee => println("Employee")
  case _ => println("Not Employee")
}

// A field or method can be declared protected. Such a member is accessible from any class but not from other locations
// Unlike in java, a protected member is not visible throughout the package to which the class belongs.
// A class has one primary constructor and any number of auxiliary constructors, and that
// all auxiliary constructors must start with a call to a preceding auxiliary constructor or primary constructor
// In consequence, the auxiliary constructors can never invoke superclass constructor directly. Only primary constructor can call a super class constructor

class Parent(val name: String, val age: Int)

class Child(name: String, age: Int, val gender: String) extends Parent(name, age)

val child = new Child("kid", 3, "female")

abstract class ABC {
  def id:Int // Each person has an ID that is computed in some way
}

class DEF(override val id:Int) extends ABC

// A def can only override another def
// A val can only override another val or a parameterless def
// A var can only override an abstract vary