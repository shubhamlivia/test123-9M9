/**
 * Refer: https://www.youtube.com/watch?v=3RyKP6jM8SQ
 */
package scalaDS.Search

object SequentialSearch extends App{

  def sequentialSearch(a: Array[Int], lookingFor: Int): Int = {
    var i = 0
    while (i < a.length && a(i) != lookingFor) i += 1
    if (i < a.length) i else -1
  }

  val nums = Array(1,6,3,8,4,7,8,9,6,4,33,56,7,8,65,43)

  println(sequentialSearch(nums, 4))
  println(sequentialSearch(nums, 7))
  println(sequentialSearch(nums, 2))
}
