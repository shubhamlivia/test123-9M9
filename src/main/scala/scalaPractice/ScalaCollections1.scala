package scalaPractice

object ScalaCollections1 {
  //def add(): Unit = {

    val numbers = List(1,2,3,4,5)
    val evennums = numbers.filter(x=> x%2==0)
    println(evennums.mkString(", "))

    var sum=0

    for(n <- numbers)
      {
        sum= sum + n
      }

    println(sum)

    /**
     * Program to count the occurrences of each element in a List:
     */

    /**
     * approach 1
      */

    val fruits = List("apple", "banana", "apple", "orange", "banana", "apple")
    val occurrences = fruits.distinct.map(fruit => fruit -> fruits.filter(x=> x == fruit).length).toMap
    println("Occurrences: " + occurrences)

    /**
     * approach 2
     */
//    val fruits = List("apple", "banana", "apple", "orange", "banana", "apple")
//    var occurrences = Map[String, Int]()
//
//    for (fruit <- fruits) {
//      if (occurrences.contains(fruit)) {
//        occurrences += (fruit -> (occurrences(fruit) + 1))
//      } else {
//        occurrences += (fruit -> 1)
//      }
//    }
//
//    println("Occurrences: " + occurrences)
//
//    val studentAges = Map("Alice" -> 20, "Bob" -> 22, "Charlie" -> 19)
//
//    val updateAges = studentAges + ("Dave" -> 33)
//
//    println(updateAges)

    /**
     * approach 3
     */

//    val fruits = List("apple", "banana", "apple", "orange", "banana", "apple")
//    var occurrences: List[(String, Int)] = List()
//
//    for (fruit <- fruits) {
//      val existingIndex = occurrences.indexWhere(_._1 == fruit)
//      if (existingIndex != -1) {
//        val (existingFruit, count) = occurrences(existingIndex)
//        occurrences = occurrences.updated(existingIndex, (existingFruit, count + 1))
//      } else {
//        occurrences = occurrences :+ (fruit, 1)
//      }
//    }
//
//    println("Occurrences: " + occurrences.toMap)

    /**
     * approach 4
     */

//    val fruits = List("apple", "banana", "apple", "orange", "banana", "apple","jack","grapes")
//    var distinctFruits: List[String] = List()
//
//    for (fruit <- fruits) {
//      if (!distinctFruits.contains(fruit)) {
//        distinctFruits = distinctFruits :+ fruit
//      }
//    }
//
//    println(distinctFruits)
//
////    val p = distinctFruits.map(disFruit => disFruit -> fruits.filter(x=> x==disFruit).length).toMap
////    println("p : "+ p)
//
//    val occurrences = Array.ofDim[(String, Int)](distinctFruits.length)
//
//    println(occurrences.mkString(", "))
//
//    for (i <- distinctFruits.indices) {
//      println("i: "+ i)
//      var count = 0
//      for (fruit <- fruits) {
//        println("fruit: "+ fruit)
//        if (fruit == distinctFruits(i)) {
//          count += 1
//          println("count: " + count)
//        }
//      }
//      occurrences(i) = (distinctFruits(i), count)
//      println("occurances: " + occurrences.mkString(" : "))
//    }
//
//    println("Occurrences: " + occurrences.toMap)
//  }

  /**
   * Find max element in an array
   */

    def maxelement(): Unit = {
      val arr = Array(2,4,1,44,6,11,20,11)
      var maxelement = arr(0)

      for(i <- 0 to arr.length-1)
        {
          if(arr(i) > maxelement )
            {
              maxelement = arr(i)
            }
        }
      println(maxelement)
    }

  /**
   * Find mean of the given array of elements
   */

  def meanelements(): Unit = {
    val arr = Array(2, 4, 1, 44, 6, 11, 20, 11)
    var sum=0

    for (i <- 0 to arr.length - 1) {
      sum = sum + arr(i)
    }
    val mean = sum / arr.length.toDouble
    println(mean)
  }

  def isPrime(n: Int): Boolean = {
    if (n <= 1) {
      false
    } else {
      !(2 until n).exists(x => n % x == 0)
    }
  }

  def main(args: Array[String]): Unit = {
    //add()
    maxelement()
    meanelements()

    val numbers = List(2,15)

    val primeNumbers = numbers.filter(isPrime)

    if (primeNumbers.nonEmpty) {
      println("Prime numbers found: " + primeNumbers.mkString(", "))
    } else {

      println("No prime numbers found.")
    }
  }
}
