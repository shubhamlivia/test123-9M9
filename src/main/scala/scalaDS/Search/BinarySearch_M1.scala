/**
 * Binary search using method 1. Sorted array without any duplicate elements, means if element exists, exists once.
 * logic taken from : https://www.youtube.com/watch?v=TomQQb2kJvc
 * algorithm taken from: https://www.youtube.com/watch?v=v9IWor4n0Ys
 */
package scalaDS.Search

object BinarySearch_M1 {

  def binSearch(arr: Array[Int], x: Int): Int = {
    def search(start: Int, end: Int): Int = {
      val mid = (start + end) / 2
      if (arr(mid) == x) {
        mid
      } else if (start == end) {
        -1
      } else if (arr(mid) > x) {
        search(start, mid - 1)
      } else {
        search(mid + 1, end)
      }
    }

    search(0, arr.length - 1)
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(2, 7, 9, 11, 20, 25, 27, 50, 51, 60)
    val target = 60
    val result = binSearch(arr, target)
    if (result != -1) {
      println(s"The element $target is found at index $result.")
    } else {
      println(s"The element $target is not found in the array.")
    }
  }
}
