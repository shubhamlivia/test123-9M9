package scalaDS.Sort

object selectionSort extends App{
  def minSort(a:Array[Int]):Array[Int] = {
    for(i<-0 until a.length - 1){
      var min=i
      for(j <- i+1 until a.length){
        if(a(j) < a(min))
          min=j
      }
      val tmp = a(i)
      a(i) = a(min)
      a(min) = tmp
    }
    a
  }

  println(minSort(Array(0,8,2,0,11,67,23)).mkString(","))
}


