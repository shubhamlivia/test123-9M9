/**
 * Exercise 1:
Write a function that takes a list of integers and returns the sum of all the prime numbers in the list.

Exercise 2:

Write a function that takes a list of integers and returns a new list where each element
is replaced by the factorial of that element.

Exercise 4:
Write a function that takes a list of integers and returns a new list where each element is
the product of the digits of the original number.

Exercise 5:

Write a function that takes a list of integers and returns the second largest element in the list.

Exercise 6:
Write a function that takes a list of integers and returns the number of perfect squares in the list.

Exercise 9:
Write a function that takes a list of integers and returns a new list where each element
is replaced by the sum of the digits raised to the power of their position (index) in the original number.
 if number is 123 => 1 pow 0 + 2 pow 1 + 3 pow 2 = 1+ 2 + 9 =12
 */

package scalaCollections

object Lists3 extends App{

  def sumofPrimeNumbers(lst:List[Int]):Int = {
    var sum=0
    for(i<-0 to lst.length-1)
      {
        if(isPrime(lst(i))) {
            sum= sum + lst(i)
        }
      }
    sum
  }

  def isPrime(n: Int): Boolean = {
    if (n <= 1) {
      false
    } else {
      !(2 until n).exists(x => n % x == 0)
    }
  }
  println(sumofPrimeNumbers(List(4,6,8,10)))

  def sumOfPrimeNumbers1(lst: List[Int]): Int = {
    lst.filter(isPrime).sum
  }
  println(sumOfPrimeNumbers1(List(1,2,3,4,5)))

  def elementFactorial(lst: List[Int]): List[Int] = {
    var factelement: List[Int] = List()

    for (i <- 0 until lst.length) {
      var sum = 1

      if (lst(i) > 1) {
        for (j <- 1 to lst(i)) {
          sum = sum * j
        }
      }

      factelement = factelement :+ sum
    }

    factelement
  }

  println(elementFactorial(List(1,2,3,4,5)))

  def duplicateElements(lst:List[Int]):List[Int] = {
    var uniqueElements:List[Int] = List()
    for(i<-0 to lst.length-1){
      if(!uniqueElements.contains(lst(i))){
        uniqueElements = uniqueElements :+ lst(i)
      }
    }
    uniqueElements
  }

  println(duplicateElements(List(9,9,9,1,7,7,3,3,2,2)))

  def perfectSquares(lst:List[Int]):Int = {
    var count =0
    for(i<-0 to lst.length-1){
      val sqrt = Math.sqrt(lst(i).toDouble)
      if(sqrt.toInt * sqrt.toInt == lst(i)){
        count = count + 1
      }
    }
    count
  }
  println(perfectSquares(List(11,3,5,4,9)))


    def sumDigitsRaisedPosition(nums: List[Int]): List[Int] = {
      def calculateSum(num: Int): Int = {
        val digits = num.toString.map(_.asDigit)
        println(digits.mkString(","))
        digits.zipWithIndex.map { case (digit, index) => math.pow(digit, index).toInt }.sum
      }

      nums.map(calculateSum)
    }


      val nums = List(123,8,9,45,3)
      val result = sumDigitsRaisedPosition(nums)
      println(result) // Output: List(12, 42, 90)
}
