package scalaPractice

object sclapractice1 {

  def dropduplicates(): Unit = {
    val arr = Array(1,2,3,2,1)

    var uniqArray = Array[Int]()

    for(elem <- arr)
      {
        if(!uniqArray.contains(elem))
          {
            uniqArray :+= elem
          }
      }

    for (eachelem <- uniqArray) {
      println(eachelem)
    }

  }

def fruitOccrance(): Unit = {
  val fruits = List("apple", "banana", "apple", "orange", "banana", "apple")
  val occurrences = fruits.distinct.map(fruit => fruit -> fruits.filter(x => x == fruit).length).toMap
  println("Occurrences: " + occurrences)
}

  def maxelement(): Unit = {
    val list = Array(1,22,33,1,55,2,90,33,22)

    var maxelement = list(0)
    for(i<-0 to list.length-1)
      {
        if(list(i) > maxelement)
          {
            maxelement = list(i)
          }
      }
  }

  def main(args: Array[String]): Unit = {
    dropduplicates()
    fruitOccrance()
  }
}
