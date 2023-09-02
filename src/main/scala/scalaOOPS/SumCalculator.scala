package scalaOOPS

object SumCalculator {
  def calculateSum(numbers: List[Int]):Int = {
    var sum=0
    val startTime = System.nanoTime()
    for(number <- numbers){
      sum = sum + number

    }
    val endTime = System.nanoTime()
    println(s"Calculation took ${(endTime - startTime) / 1000000} milliseconds")

    sum
  }
  def main(args:Array[String]):Unit = {
    val numbers = (1 to 1000000).toList
    val sum = calculateSum(numbers)
    println(s"Sum of numbers: $sum")
  }
}
