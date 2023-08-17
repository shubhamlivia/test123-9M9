/**
 * merge sort algorithm: https://www.youtube.com/watch?v=Axva2VdsXkk
 * https://www.youtube.com/watch?v=XX4qmWxYv-c
 * code logic is from: https://www.youtube.com/watch?v=dx12ek3RmUU
 */
package scalaDS.Sort

object mergeSort_M1 extends App{

  def mergeSort(arr: Array[Int]): Array[Int] = {
    if (arr.length <= 1) {
      arr
    } else {
      val mid = arr.length / 2
      println("mid : " + mid)
      val left = mergeSort(arr.slice(0, mid))
      println("left: " + left.mkString(","))
      val right = mergeSort(arr.slice(mid, arr.length))
      println("right: " + right.mkString(","))
      println("into merge function")
      merge(left, right)

    }
  }

  def merge(left: Array[Int], right: Array[Int]): Array[Int] = {
    var mergedArray = Array[Int]()
    var i = 0
    var j = 0

    while (i < left.length && j < right.length) {
      if (left(i) <= right(j)) {
        mergedArray :+= left(i)
        i += 1
      } else {
        mergedArray :+= right(j)
        j += 1
      }
    }

    while (i < left.length) {
      mergedArray :+= left(i)
      i += 1
    }

    while (j < right.length) {
      mergedArray :+= right(j)
      j += 1
    }
    //println("Merged Array: " + mergedArray.mkString(",")
    mergedArray
  }

  // Example usage
  //val unsortedArray = Array(11,5,70,42,30)
  val unsortedArray = Array(11,5,70,42,30,25,27,21,8,3,2)
  val sortedArray = mergeSort(unsortedArray)
  println(sortedArray.mkString(", "))  // Output: 1, 2, 3, 4, 5, 8

}
