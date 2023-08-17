package scalaDS.Sort

object bucketSort extends App{
  def bucketSort(a: Array[Int]): Array[Int] = {
    val min = a.min
    val max = a.max
    val buckets = Array.fill(a.length)(List[Int]())
    for (x <- a) {
      val b = (x - min) * (buckets.length - 1) / (max - min)
      buckets(b) ::= x
    }
    var i = 0
    for (bucket <- buckets; x <- bucket) {
      a(i) = x
      i += 1
    }
    minSort(a)

  }

  def minSort(a: Array[Int]): Array[Int] = {
    for (i <- 0 until a.length - 1) {
      var min = i
      for (j <- i + 1 until a.length) {
        if (a(j) < a(min))
          min = j
      }
      val tmp = a(i)
      a(i) = a(min)
      a(min) = tmp
    }
    a
  }
  println(minSort(Array(0, 8, 2, 0, 11, 67, 23)).mkString(","))
}
