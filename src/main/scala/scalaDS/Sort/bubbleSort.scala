package scalaDS.Sort

object bubbleSort extends App{

 def bubbleSort(a: Array[Int]):Array[Int] = {
    for(i<- 0 until a.length - 1) {
     for(j<-0 until a.length-1-i) {
       if(a(j) < a(j+1)){
         val tmp = a(j)
         a(j) = a(j+1)
         a(j+1) =tmp
       }
     }
   }
   a
  }

  println(bubbleSort(Array(1,8,2,0,11,67,23)).mkString(","))

  val arr = Array(1,8,2,0,11,67,23)
  println(arr.length)
}
