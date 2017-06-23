// A function is a first-class citizen

import scala.math._

val num = 3.14 // type : Double
val fun = ceil _ // type : (Double) => Double

// A function can be called , stored, or passed to another function/method

// Call Function
fun(num) // 4.0; same as method ceil(3.14)
ceil(3.14)

// Pass function to another function / method
Array(3.14, 1.42, 2.0).map(fun) // Array(4.0, 2.0, 2.0)
// Anonymous function
Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x) // Array(9.42, 4.26, 6.0)
Array(3.14, 1.42, 2.0).map(3 * _)

val triple = (x: Double) => 3 * x // function
Array(3.14, 1.42, 2.0).map(triple)

def triple(x: Double) = 3 * x // method

// functions / methods can have function parameters
def valueAtOneQuarter(f: (Double) => Double) = f(0.25)

valueAtOneQuarter(ceil _) // 1.0
valueAtOneQuarter(sqrt _) // 0.5

def valueAtOneQuarter2(f: (Double) => Double, x: Double) = f(x)
valueAtOneQuarter2(ceil _, 1.25) // 2.0

// function can produce another function
def mulBy(factor: Double) = (x: Double) => factor * x // type (Double) => ((Double) => Double)
mulBy(3) // returns function 3 * x
val quintuple = mulBy(5)
quintuple(20) // 100

valueAtOneQuarter((x: Double) => 3 * x)
// same as, Double is omitted as parameter and return type are same
valueAtOneQuarter(x => 3 * x)
// same as, if parameter variable occurs only once, can be replaced with _
valueAtOneQuarter(3 * _)

// map transforms the values
(1 to 9).map(0.1 * _) // 0.1, 0.2, ....., 0.9
(1 to 9).map("*" * _).foreach(println _)
// filter retains the elements that fulfill a predicate
(1 to 9).filter(_ % 2 == 0) // 2, 4, 6, 8
// reduceLeft applies a binary function, going from left to right
(1 to 9).reduceLeft(_ * _)

(1 to 9).filter(_ % 2 == 0).map(0.1 * _)
// same as
for (n <- 1 to 9 if n % 2 == 0) yield 0.1 * n

// Closure
def multBy(factor: Double) = (x: Double) => factor * 2
val triplet = multBy(3) // function + values of free variables (i.e 3) = closure, 3 is stored in triplet
triplet(14) // 42

// Currying
// Turning a function that takes two arguments into a function that takes one argument.
// That function returns a function that consumes the second argument
def mul(x: Int, y: Int) = x * y
// curried version
def mulOneAtATime(x: Int) = (y: Int) => x * y
// def mulOneAtATime(x: Int)(y: Int) = x * y // same as above
mulOneAtATime(3) // returns a function 3 * y
mulOneAtATime(3)(14) // 42

val a = Array("Hello", "World")
val b = Array("hello", "world")
a.corresponds(b)(_.equalsIgnoreCase(_)) // true

def runInThread(block: => Unit) {
  new Thread {
    override def run() {
      block
    }
  }.start()
}

runInThread {
  println("Hi");
  Thread.sleep(10000);
  println("Bye")
}



