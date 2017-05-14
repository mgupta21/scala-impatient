class BankAccount(initialBalance: Double) {

  private var balance = initialBalance

  def currentBalance = balance

  def deposit(amount: Double) = {
    balance += amount;
    balance
  }

  def withdraw(amount: Double) = {
    balance -= amount;
    balance
  }

}

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {

  override def deposit(amount: Double) = {
    super.deposit(amount)
    super.withdraw(1)
  }

  override def withdraw(amount: Double) = {
    super.withdraw(amount)
    super.withdraw(1)
  }

}

val account = new CheckingAccount(100)
account.deposit(5)
account.currentBalance
account.withdraw(4)

class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {

  var count = 3

  override def deposit(amount: Double) = {
    super.deposit(amount)
    if (count <= 0) {
      super.withdraw(1)
    }
    count -= 1
    currentBalance
  }

  override def withdraw(amount: Double) = {
    super.withdraw(amount)
    if (count <= 0) {
      super.withdraw(1)
    }
    count -= 1
    currentBalance
  }

  def earnMonthlyInterest = {
    super.deposit(currentBalance * 0.02)
  }

}

val savingsAccount = new SavingsAccount(100)
savingsAccount.earnMonthlyInterest
savingsAccount.currentBalance

savingsAccount.withdraw(10)
savingsAccount.deposit(10)
savingsAccount.withdraw(10)
savingsAccount.deposit(10)

class Person(val name: String)

class Employee(name: String, val id: Int) extends Person(name)

class Manager(name: String, id: Int, val numberOfEmployees: Int) extends Employee(name, id)

val manager = new Manager("John", 3334, 10)
manager.name

abstract class Item {

  def price: Int

  def description : String
}

class SimpleItem(override val price: Int, override val description: String) extends Item {

}

class Bundle(val items: List[Item]) extends Item {
  def price = items.map(_.price).sum
  def description = "Surperise Bundle"
}

val bundle = new Bundle(List(new SimpleItem(2, ""), new SimpleItem(3, "")))
bundle.price