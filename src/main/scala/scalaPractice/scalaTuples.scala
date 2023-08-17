package scalaPractice

object scalaTuples extends App{


def getUserInfo(userID: Int): (String, Int, Boolean) ={
  val name = "John"
  val age = 25
  val isActive = true

  (name, age, isActive)
}

  val userInfo = getUserInfo(12345)

  val name = userInfo._1
  val age = userInfo._2
  val isActive = userInfo._3


  //val (name, age, isActive) = userInfo

  println(s"Name: $name, Age: $age, IsActive: $isActive")

  val fruits = List("apple","orange","mango")

  fruits.zipWithIndex.map{ case (fruit, index) => println(s"$index: $fruit ")}

  val person = ("John", 25, "Boston")

  person match {
    case (name, age, city) => println(s"Name: $name, Age: $age, City: $city")
    case _ => println("Invalid person")
  }
    /**
     * Pattern matching
     */

    val x: Any = 5

      x match {
        case 1 => println("One")
        case 2 => println("Two")
        case 3 => println("Three")
        case _ => println("Other")
      }

  val y = 6

  y match{
    case 1 => println("one")
    case _ => println("not found")
  }

  val list1 = 1 :: 2 :: Nil

  val list2  = Nil

  println(list1)

  val list = List(1,2,3)
  val number = 4

  val newlist = list :+ number :+ 6

  val updatedlist = newlist ++ Nil
  println(updatedlist)

  val x1 = null
  println(x1)

  val x2 : Option[String] = None
  println(x2)

  /**
   * closures in scala
   */

  def multiplyBy(factor: Int):Int => Int = {
    (x: Int) => x * factor
  }

}
