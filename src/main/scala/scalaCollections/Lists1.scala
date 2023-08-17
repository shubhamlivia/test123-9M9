/**
 * Exercise 1:
Write a function that takes a list of integers and returns the sum of all the even numbers in the list.

Exercise 2:
Write a function that takes two lists of integers and returns a new list containing only the elements that appear in both lists.

Exercise 3:
Write a function that takes a list of strings and returns a new list where each string is repeated three times.

Exercise 4:
Write a function that takes a list of strings and returns a new list where the strings are sorted in descending order of their lengths.

Exercise 5:
Write a function that takes a list of integers and returns a new list where each element is multiplied by its index in the list.

Exercise 6:
Write a function that takes a list of strings and a separator string, and returns a new string where the elements of the
list are concatenated with the separator in between.

Exercise 7:
Write a function that takes a list of integers and returns the largest prime number in the list.

Exercise 8:
Write a function that takes a list of strings and returns a new list where each string is reversed.

Exercise 9:
Write a function that takes a list of integers and returns a new list where each element is the sum of all the previous elements in the list.

Exercise 10:
Write a function that takes a list of strings and returns a new list where each string is capitalized and reversed.
 */
package scalaCollections

object Lists1 extends App {

  def sumOfEvenNumbers(lst: List[Int]): Int = {
    val filterlist = lst.filter(x => x % 2 == 0)
    var sum = 0
    for (x <- filterlist) {
      sum = sum + x
    }
    sum
  }

  println(sumOfEvenNumbers(List(1, 2, 3, 7, 8)))

  def commonElements(lst1: List[Int], lst2: List[Int]): List[Int] = {
    val commonlist = lst1.filter(lst2.contains)
    commonlist
  }

  println(commonElements(List(0, 22, 3, 4, 7, 9), List(88, 1, 4, 0, 21, 77)))

  def repeatStrings(lst: List[String]): List[String] = {
    var repeatstr: List[String] = List()
    for (str <- lst) {
      for (i <- 0 to 2) {
        repeatstr = repeatstr :+ str
      }
    }
    repeatstr
  }

  println(repeatStrings(List("hello", "chandra", "kanth")))

  def sortStringsByLengthDesc(lst: List[String]): List[String] = {
    lst.map(x => (x, x.length)).sortBy(x => x._2).map(x => x._1)
  }

  println(sortStringsByLengthDesc(List("chandra", "kanth", "inevitable", "cosmetics", "duration", "duration")))

  def multiplyByIndex(lst: List[Int]): List[Int] = {
    lst.zipWithIndex.map(x => (x._1 * x._2))
  }

  println(multiplyByIndex(List(0, 4, -5)))

  def multiplyByIndex1(lst: List[Int]): List[Int] = {

    var multiplylist: List[Int] = List()

    //for(i<- 0 to lst.length-1; element<- lst)
    //Issue: The nested loop structure for(i<- 0 to lst.length-1; element<- lst) is incorrect because it iterates over each element of the
    // list lst for every index i. This leads to incorrect multiplication and duplication of elements in the multiplylist.
    //
    //Explanation of the incorrect output: Since the nested loop iterates over each element of the list for every index,
    // it multiplies each element by all possible indices. This results in duplication of elements and incorrect multiplication.
    // For example, when i = 0, every element is multiplied by 0, resulting in the first three zeros in the output.
    // Similarly, when i = 1, every element is multiplied by 1, giving the next three elements in the output, and so on.
    for (i <- 0 to lst.length - 1; element = lst(i)) //used multiple conditions in for loop
    {
      multiplylist = multiplylist :+ element * i
    }
    multiplylist
  }

  println(multiplyByIndex1(List(1, 2, 3)))

  def multiplyByIndex2(lst: List[Int]): List[Int] = {
    var multiplylist: List[Int] = List()

    val tupleindex = lst.zipWithIndex

    for ((element, index) <- tupleindex) {
      multiplylist = multiplylist :+ element * index
    }

    multiplylist
  }

  println(multiplyByIndex2(List(9, 8, 7)))

  def concatenateWithSeparator(lst: List[String], str: String): String = {

    var concatstr = ""
    for (i <- 0 to lst.length - 1) {
      if (i < lst.length - 1) {
        concatstr = concatstr + lst(i).concat(str)
      }
      else {
        concatstr = concatstr + lst(i)
      }
    }
    concatstr
  }

  println(concatenateWithSeparator(List("hello", "chandra", "kanth", "how", "r you"), ":"))

  import scala.util.Random

  def caesarCipher(strings: List[String]): List[String] = {
    val alphabet = 'A' to 'Z'
    val shiftRange = 0 to 25
    val random = new Random()

    strings.map { str =>
      val shift = random.nextInt(shiftRange.length)
      str.map { c =>
        if (alphabet.contains(c.toUpper)) {
          val currentIndex = alphabet.indexOf(c.toUpper)
          val newIndex = (currentIndex + shift) % alphabet.length
          val shiftedChar = alphabet(newIndex)
          if (c.isLower) shiftedChar.toLower else shiftedChar
        } else {
          c
        }
      }
    }
  }

  println(caesarCipher(List("hello", "chandra", "kanth", "tune", "run")))

  def sumofpreviousElements(lst: List[Int]): List[Int] = {
    var prevElem: List[Int] = List()

    for (i <- 0 to lst.length - 1) {
      var sum = 0

      if (i == 0) {
        prevElem = List(0)
      }
      else {
        for (j <- 0 to i-1) {
          sum = sum + lst(j)
        }
        prevElem = prevElem :+ sum
      }
     }
    prevElem
  }
  println(sumofpreviousElements(List(0,2,0,5,6,9)))

  def capitalizeAndReverse(lst:List[String]):List[String] = {
    lst.map(x=> x.reverse).map(x=> x.toUpperCase())
  }

  println(capitalizeAndReverse(List("chandra","kanth","paper","output")))
}
