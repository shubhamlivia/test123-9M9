/**
1.
 Every student receives a grade in the inclusive range from 0 to 100. Any grade less than 40 is a failing grade.
Sam is a professor at the university and likes to round each student's grade according to these rules:
If the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next multiple of 5.
If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.
write a scala program for the above query.

2.

You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates.
You are allowed to swap any two elements. Find the minimum number of swaps required to sort the array in ascending order
 */
package scalaCollections

object Lists4 extends App{
  def roundGrade(lst: List[Int]): List[Int] = {
    for (i <- 0 until lst.length) yield {
      if (lst(i) < 38) {
        lst(i)
      } else {
        val nextMultipleOf5 = (lst(i) / 5) * 5 + 5
        if (nextMultipleOf5 - lst(i) < 3)
          nextMultipleOf5
        else
          lst(i)
      }
    }
  }.toList

  println(roundGrade(List(38,39,44,43,77,83,81)))


  def roundGrade1(lst: List[Int]): List[Int] = {
    var roundedList:List[Int]  = List()
    for (i <- 0 until lst.length) {
      if (lst(i) < 38) {
        roundedList = roundedList :+ lst(i)
      } else {
        val nextMultipleOf5 = (lst(i) / 5) * 5 + 5
        if (nextMultipleOf5 - lst(i) < 3)
          roundedList = roundedList :+nextMultipleOf5
        else
          roundedList = roundedList :+ lst(i)
      }
    }
    roundedList
  }

  println(roundGrade1(List(38, 39, 44, 43, 77, 83, 81)))

  def minimumSwaps(arr: Array[Int]): Int = {
    val n = arr.length
    var swaps = 0

    for (i <- 0 until n) {
      var curr = arr(i)
      while (curr != i + 1) {
        val temp = arr(curr - 1)
        arr(curr - 1) = curr
        curr = temp
        swaps += 1
      }
    }

    swaps
  }

  println(minimumSwaps(Array(7,1,3,2,4,5,6)))
}
