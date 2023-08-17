package scalaDS.Sort

object quickSort extends App{

   def quickSort(a: Array[Int]): Array[Int] = {
      if (a.length <= 1) {
        a
      } else {
        val pivot = a(a.length / 2)
        val less = a.filter(_ < pivot)
        val equal = a.filter(_ == pivot)
        val greater = a.filter(_ > pivot)

        quickSort(less) ++ equal ++ quickSort(greater)
      }
    }

    val inputArray = Array(0, 8, 2, 0, 11, 67, 23)
    val sortedArray = quickSort(inputArray)
    println(sortedArray.mkString(","))

}
