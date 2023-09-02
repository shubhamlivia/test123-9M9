/**
 * simple banking application with different account types, including checking and savings accounts.
 */
package scalaOOPS

trait MyAccount {
  def balance :Double
  def deposit(amount: Double): Unit
  def withdraw(amount:Double):Unit
}

class CheckingAccount(initialBalance : Double) extends MyAccount{
  private var _balance = initialBalance
  def balance: Double = _balance
  def deposit(amount: Double):Unit = {
    _balance +=amount
  }

  def withdraw(amount:Double):Unit = {
    if(_balance >= amount){
      _balance -= amount
    } else {
      println("Insufficient balance")
    }
  }
}

class SavingsAccount(initialBalance: Double) extends MyAccount {

  private var _balance:Double = initialBalance
  def balance: Double = _balance
  def deposit(amount: Double):Unit = {
    _balance += amount
  }

  def withdraw(amount:Double):Unit = {
    val penalty= 5
    if(_balance >= amount){
      _balance -=amount
      if(_balance < 0) _balance -= penalty
    } else {
      println("Insufficient Balance")
    }
  }
}
object BankingApp {
  def main(args: Array[String]): Unit = {
    val checkingAccount = new CheckingAccount(1000)
    val savingsAccount = new SavingsAccount(1500)

    println(s"Checking Account Balance: ${checkingAccount.balance}")
    println(s"Savings Account Balance: ${savingsAccount.balance}")

    checkingAccount.withdraw(200)
    savingsAccount.withdraw(300)

    def showBalance(account: MyAccount):Unit = {
      println(s"Account Balance: ${account.balance}")
    }
    showBalance(checkingAccount)
    showBalance(savingsAccount)
  }
}
