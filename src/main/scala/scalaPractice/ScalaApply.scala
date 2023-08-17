package scalaPractice

object ScalaApply extends App {

  class Calculator {
    def add(x: Int, y: Int): Int = x + y

    def subtract(x: Int, y: Int): Int = x - y
  }

  object Calculator {
    def apply(): Calculator = new Calculator()

    def apply(x: Int, y: Int, operation: String): Int = {
      val calculator = new Calculator()

      operation match {
        case "add" => calculator.add(x, y)
        case "subtract" => calculator.subtract(x, y)
        case _ => throw new IllegalArgumentException("Invalid operation")
      }
    }
  }

  // Creating an instance of Calculator using the default apply method
  val calculator1 = Calculator()

  // Using the custom apply method to perform operations
  val result1 = Calculator(10, 5, "add") // result1 = 15
  val result2 = Calculator(10, 5, "subtract") // result2 = 5
}
