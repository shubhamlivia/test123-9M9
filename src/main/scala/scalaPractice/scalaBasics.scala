package scalaPractice

object scalaBasics{

  val numbers: List[Int] = List(1, 2, 3, 4, 5)

  // Accessing elements in a list
  println("First element: " + numbers.head)
  println("Last element: " + numbers.last)
  println("Element at index 2: " + numbers(2))

  println( numbers ++ List(7,8,9))

  def Collections_scala(): Unit= {

    val numbers = Array(2,2,2,2,2)

    val unique_num =numbers.toSet.toArray

    for(elem <- unique_num){
      println(elem)
    }

    val duplicatenumbers = Array(1,2,3,4)

    println(duplicatenumbers.mkString(","))

    var emptyArray = Array[Int]()

    println(emptyArray.mkString(","))

    for(elem <- duplicatenumbers){
      if(!emptyArray.contains(elem)){
        emptyArray :+= elem
      }
    }

    for(eachelem <- emptyArray)
      {
        println(eachelem)
      }

    val x = Set(1,2,3,4,2,3)
    println(x)


    val map1 = Map("one" -> 1, "two" -> 2, "three" ->3)

    println(map1("two"))

    val a = Array(1,2,3,4,7,8,9)

    a.foreach(println)

  }

  def factorial_num(x: Int): Int = {
    if (x == 1) {
      1
    }
    else {
      x * factorial_num(x - 1)
    }
  }

  def factorial_acc(acc: Long, x: Long): Long = {
    if (x <= 1)
      acc
    else
    factorial_acc( acc * x,x - 1)

  }

  def dropduplicates() = {
    val array = Array(2, 2, 2, 2, 2)
    var uniqueArray = Array.empty[Int]

    for (element <- array) {
      if (!uniqueArray.contains(element)) {
        uniqueArray = uniqueArray :+ element
        println(uniqueArray.mkString(" "))
      }
    }
  }


  def main(args: Array[String]): Unit = {
    Collections_scala()
    println(factorial_num(5))
    println(factorial_acc(1,500000000))

    val lst = List(1,2,3,4)
    val newlst = 9 +: lst
    println(newlst)
  }


}
