/**
 * Refer: https://www.youtube.com/watch?v=5oNM_m5qszo
 */

package scalaDS.Search

object BinarySearch1 extends App{

  def binarySearch(a: Array[Int], lookingFor: Int):Int = {
    var start = 0
    var end = a.length
    var mid = (start + end) / 2
    while (a(mid) != lookingFor && start < end) {
      if (lookingFor < a(mid)) end = mid
      else start = mid + 1
      mid = (start + end) / 2
    }
    if (a(mid) == lookingFor) mid else -1
  }

  val nums = Array(1,6,3,8,4,7,8,9,6,4,33,56,7,8,65,43)
  val snums = nums.sorted
  println(binarySearch(snums, 4))
  println(binarySearch(snums, 7))
  println(binarySearch(snums, 2))
}
