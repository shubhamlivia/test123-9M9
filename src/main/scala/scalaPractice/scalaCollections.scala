package scalaPractice

object scalaCollections extends App{

  var num1 =10
  var num2 = 20

  println(s" Before swap: num1 = $num1, num2 = $num2")

  val temp = num1
  num1 = num2
  num2 = temp

  println(s" After swap: num1 = $num1, num2 = $num2")

  val arrlist = Array(1,2,3,4,5,8)

  println(arrlist.reverse.mkString(", "))

  var arrcount = arrlist.length

  var emptyArr = new Array[Int](arrcount)

  println(arrlist.mkString(", "))

  var m=0

  for(i <- (arrcount-1) to 0 by -1)
    {
      emptyArr(m) = arrlist(i)
      m +=1
    }
  println(emptyArr.mkString(", "))
}
