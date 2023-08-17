package scalaOOPS

object OOPSConcepts extends App{

class Vehicle {
  def drive(): Unit = {
    println("Driving....???")
  }
}

class Car extends Vehicle{
  def accelarate(): Unit = {
    println("Accelerating.....")
  }
}

  val car = new Car()
  car.drive()
  car.accelarate

  abstract class Shape() {
    def area():Double
  }

  trait Colorful {
    def color: String
  }

  class Circle(radius: Double) extends Shape with Colorful {
    def area():Double = {
      Math.PI * radius * radius
    }

  def color: String = {
    "Red"
  }
  }
  val circle = new Circle(5.0)
  println(circle.area())   // Output: 78.53981633974483
  println(circle.color)    // Output: Red

  trait Greeting {
    def greet(name: String): Unit
  }

  val greeting: Greeting = new Greeting {
    def greet(name: String): Unit = {
      println(s"Hello, $name!")
    }
  }

  greeting.greet("John") // Output: Hello, John!


  case class Person(name: String, age: Int)

  val john = Person("John", 30)
  val jane = Person("Jane", 28)

  println(john.name) // Output: John
  println(jane.age) // Output: 28


}


