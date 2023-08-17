package scalaDS.Sort

object insertionSort extends App{

  def insertionSort(a:Array[Int]):Array[Int] = {
    for(i<-1 until a.length){
      var j = i-1
      var tmp = a(i)
      while(j>=0 && tmp < a(j)){
        a(j+1) = a(j)
        j -=1
      }
      a(j+1) = tmp
    }
    a
  }
  println(insertionSort(Array(0,8,2,0,11,67,23)).mkString(","))

}


