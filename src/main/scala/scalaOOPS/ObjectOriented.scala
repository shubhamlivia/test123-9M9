package scalaOOPS
import scala.collection.mutable.ListBuffer
object ObjectOriented extends App{
  //create account and observer
  val account = new Account("12345", 1000.0)
  val emailNotifier = new EmailNotifier()

  //Add observer to the account
  account.addObserver(emailNotifier)

  //Perform operations
  account.withdraw(500)
  account.deposit(200)

  //Remove observer
  account.removeObserver(emailNotifier)
  account.withdraw(300)

}

/**
 * Oberserver Interface
 */
trait Observer {
  def update(message: String): Unit
}

/**
 * Account Class
 */
class Account(var accountNumber: String, var balance: Double) {
  private val observers: ListBuffer[Observer] = ListBuffer()

  def addObserver(observer: Observer): Unit = {
    observers += observer
  }

  def removeObserver(observer: Observer): Unit = {
    observers -= observer
  }

  def notifyObservers(message: String): Unit = {
    observers.foreach(eachobserver => eachobserver.update(message))
  }

  def withdraw(amount: Double): Unit = {
    if (balance >= amount) {
      balance -= amount
      notifyObservers(s"Withdrew $amount. New Balance: $balance")
    } else {
      println("Insufficient Balance")
    }
  }

  def deposit(amount: Double): Unit = {
    balance += amount
    notifyObservers(s"Deposited $amount. New Balance: $balance")
  }
}

class EmailNotifier extends Observer {
  override def update(message: String): Unit = {
    println(s"Sending email notification: $message")
  }
}

