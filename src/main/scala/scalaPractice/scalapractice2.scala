package scalaPractice

object scalapractice2 extends App{

  /**
   * Custom Higher Order function Example 1
   */
  val dataset = List(1, 2, 3, 4, 5)

  val addition: Int => Int = (x: Int) => x + x

  def customHigherOrderFunction(data: List[Int], operation: Int => Int): List[Int] = {
    data.map(operation)
  }

  val result = customHigherOrderFunction(dataset, addition)

  println(result)

  /**
   * Custom Higher Order function Example 2
   */
  def customHOF[A, B](data: List[A], operation: A => B): List[B] = {
    data.map(operation)
  }

  val names = List("John","Jane","Alice","Bob")

  val length:String => Int = (name:String) => name.length

  val output = customHOF(names, length)

  println(output)
}
