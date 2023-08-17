package scalaCollections

object Map1 extends App {


  val x = Map(1 -> List(10, 20, 30), 2 -> List(5, 15), 3 -> List(8, 12, 24))

  def mapvaluesum(map: Map[Int, List[Int]]): Map[Int, Int] = {
    //    var map1:Map[Int, Int] = Map()
    //    for((key,value) <- map){
    //      var sum=0
    //      for(i<-0 to value.length-1){
    //        sum = sum + value(i)
    //      }
    //      map1 = map1 + (key -> sum)
    //    }

    map.map { case (key, value) => key -> value.sum }

  }

  println(mapvaluesum(Map(
    1 -> List(10, 20, 30),
    2 -> List(5, 15),
    3 -> List(8, 12, 24)
  )))

  def twomapValuesum2(map1: Map[Int, Int], map2: Map[Int, Int]): Map[Int, Int] =
    map1.map { case (key, value) => key -> (value + map2.getOrElse(key, 0)) } ++
      map2.filterKeys(!map1.contains(_))

  def twomapValuesum(map1: Map[Int, Int], map2: Map[Int, Int]): Map[Int, Int] = {
    val result = collection.mutable.Map[Int, Int]()

    for ((key1, value1) <- map1) {
      result(key1) = result.getOrElse(key1, 0) + value1
    }

    for ((key2, value2) <- map2) {
      result(key2) = result.getOrElse(key2, 0) + value2
    }

    result.toMap.toSeq.sorted.toMap
  }

  println(twomapValuesum(
  Map(
    1 -> 10,
    2 -> 20,
    3 -> 30
  ),
  Map(
      2 -> 5,
      3 -> 15,
      4 -> 25
    )
  ))

  val maptest = Map[Int, Int](1 -> 10, 2 -> 20, 3 -> 30)
  println(maptest.mapValues(value => value *2))
  println(maptest.map{case(key,value) => key -> value *2})
  val result = for((key,value) <- maptest) yield key -> value *2
  println(result)

  def mapvaluesmultiply(map: Map[Int, List[Int]]): Map[Int, Int] = {
    map.map{case(key,value) => key -> value.product}
  }


  println(mapvaluesmultiply(Map(
    1 -> List(10, 20, 30),
    2 -> List(5, 15),
    3 -> List(8, 12, 24)
  )))

  def mapFactorialValue(map:Map[String, Int]): Map[String, Int] = {

    def factorial(x:Int):Int = {
      if(x<=1)
        1
      else
        x*factorial(x-1)
    }

    map.map{case(key,value) => key -> factorial(value)}

  }
  println(mapFactorialValue(Map("five" -> 5,"six" ->6,"one" -> 1)))

  def keywithhighestsumValues(map:Map[Int, List[Int]]):(Int, Int) = {
    map.map{case(key,value)=> key -> value.sum}.maxBy{case(key, sum) => sum}
  }

  println(keywithhighestsumValues(Map(
    1 -> List(10, 20, 30),
    2 -> List(5, 15),
    3 -> List(8, 12, 24)
  )))


  def keyWithHighestSumValues(map: Map[Int, List[Int]]): (Int, List[Int]) = {
    val ordering = Ordering.by[(Int, List[Int]), Int] { case (_, list) => list.sum }
    map.max(ordering)
  }


  println(keyWithHighestSumValues(Map(
    1 -> List(10, 20, 30),
    2 -> List(5, 15),
    3 -> List(8, 12, 24)
  )))
}
