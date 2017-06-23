// Traits - superficially similar to java interface
// A class can extend multiple traits
class Employee3(name: String, age: Int, val salary: Double) extends Person2(name, age) with Cloneable with Serializable

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