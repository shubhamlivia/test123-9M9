package scalaDS.Search

object BinarySearch2 extends App{

  def binarySearch2(a: Array[Int], value: Int): Int = {
    def binarySearchRecur(a: Array[Int], value: Int, start: Int, end: Int): Int = {
      if (end <= start) -1 else {
        val mid = (end + start) / 2
        if (a(mid) == value) mid
        else if (value < a(mid)) binarySearchRecur(a, value, start, mid)
        else binarySearchRecur(a, value, mid + 1, end)
      }
    }

    binarySearchRecur(a, value, 0, a.length)
  }

  println(binarySearch2(Array(1,2,3,4,5,6,7,8,9),19))
}
