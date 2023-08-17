package scalaPractice

import scala.collection.mutable.Map

object Implicits extends App{
  val dic:Map[String, Int] = Map()

  dic += ("apple" -> 1)
  dic += ("banana" -> 2)
  dic += ("orange" -> 3)

dic("orange")=4
  println(dic)

  println(dic.contains("apple"))

  dic -= "orange"

  println(dic)

  for((key, values) <- dic)
    {
      println(s"Key: $key, Values:$values")
    }

  /**
   * foldleft, fold
   *
   */

  var a = Array(5,7,4,9,3,7,1,6,3)

  a.foldLeft("0")(_+_)

  try {
    val result = 10 / 0
    println(result)
  } catch {
    case ex: ArithmeticException => println("Error: Divisible by zero")
    case ex: Exception => println("Error: " + ex.getMessage)
  } finally {
    println("this block will always be executed.")
  }

  /**
   * implicits in scala:
   * implicits allow you to define implicit conversions, implicit parameters, and implicit classes.
   * They provide a way to extend the behavior of existing types or add new functionalities seamlessly.
   */

  // Define a class called Person
  case class Person(name: String)

  // Define an implicit conversion to add a greeting method to Person
  implicit class PersonExtensions(person: Person) {
    def greet(): Unit = {
      println(s"Hello, ${person.name}!")
    }
  }

  // Define a function that takes an implicit parameter
  def printGreeting(implicit person: Person): Unit = {
    person.greet()
  }

  // Create an instance of Person
  val john = Person("John")

  // Call the greet method using implicit conversion
  john.greet()

  // Call the printGreeting function with implicit parameter
  implicit val implicitPerson: Person = Person("Alice")
  printGreeting


}
