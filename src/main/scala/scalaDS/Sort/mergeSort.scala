package scalaDS.Sort

object mergeSort extends App{

    def mergeSort(a: Array[Int]): Array[Int] = {
      if (a.length <= 1) {
        a
      } else {
        val mid = a.length / 2
        val (left, right) = a.splitAt(mid)
        merge(mergeSort(left), mergeSort(right))
      }
    }

    def merge(left: Array[Int], right: Array[Int]): Array[Int] = {
      var i = 0
      var j = 0
      var k = 0
      val merged = new Array[Int](left.length + right.length)

      while (i < left.length && j < right.length) {
        if (left(i) <= right(j)) {
          merged(k) = left(i)
          i += 1
        } else {
          merged(k) = right(j)
          j += 1
        }
        k += 1
      }

      while (i < left.length) {
        merged(k) = left(i)
        i += 1
        k += 1
      }

      while (j < right.length) {
        merged(k) = right(j)
        j += 1
        k += 1
      }

      merged
    }

    val inputArray = Array(0, 8, 2, 0, 11, 67, 23)
    val sortedArray = mergeSort(inputArray)
    println(sortedArray.mkString(","))

}
