package scalaPractice

import scala.collection.mutable.HashMap

object MapUsage extends App{
  val words = List("apple","banana","apple","orange","banana","apple","mango","mango","mango","mango")
  val occurances = words.distinct.map(fruit => fruit -> words.filter(x=> x== fruit).size).toMap
  val occurances_1 = words.map(x=> (x,1)).groupBy(x=> x._1).mapValues(x=> x.size)
  val wordFrequency = words.groupBy(identity).mapValues(x=> x.size)
  val wordFrequency1 = words.map(word => (word, words.count(x=> x==word))).toMap

  val wordFrequency2 = new HashMap[String, Int]().withDefaultValue(0)

  words.foreach { word =>
    wordFrequency2(word) += 1
  }
  println(wordFrequency2.toList.sortBy(x=> x._1).toMap)

  // Filtering a Map
  val filteredMap = wordFrequency2.toList.sortBy(x=> x._1).toMap.filter{case (_, value) => value > 2}
  println(filteredMap)

  //Multiple filters in Map

  val multiFilterdMap = wordFrequency2.toSeq.sortBy(x=> x._1).toMap
    .filter{case (key, value) => value >2}
    .filter{case (key,_) => key.startsWith("m")}

  println(multiFilterdMap)

  val addMap = wordFrequency2 + ("grape" -> 10)//wordFrequency2.updated("grape", 10)
  println(addMap)

  wordFrequency2.foreach { case (word, count) =>
    println(s"$word -> $count")
  }

  //merge two Maps

  val map1 = Map("apple" -> 5, "banana" -> 3)
  val map2 = Map("apple" -> 2, "orange" -> 4)

  val combinedMap = map1 ++ map2.map{case(k,v) => k -> (v + map1.getOrElse(k,0))}
  println(combinedMap)

  val map11 = Map("apple" -> 5, "banana" -> 3)
  val map22 = Map("apple" -> 2, "orange" -> 4)
  val combinedMap11 = map11 ++ map22

  println(combinedMap)
  // Output: Map(apple -> 2, banana -> 3, orange -> 4) here map2 same keys replaces values of map1

  //grouping map values

  val map33 = Map("apple" -> 5, "banana" -> 3, "orange" -> 2)
  val groupedMap = map33.groupBy { case (_, value) => if (value > 3) "High" else "Low" }
  // Output: Map(Low -> Map(banana -> 3, orange -> 2), High -> Map(apple -> 5))

  println(groupedMap)

  //Find the common key-value pairs between two maps.

  val map44 = Map("apple" -> 5, "banana" -> 3, "orange" -> 2)
  val map55 = Map("apple" -> 2, "orange" -> 4, "kiwi" -> 6)
  val intersection = map44.filterKeys(map55.contains)
  // Output: Map(apple -> 5, orange -> 2)

//Perform recursive operations on a nested map structure.

  val map = Map("fruit" -> Map("apple" -> 5, "banana" -> 3), "color" -> Map("red" -> 2, "yellow" -> 4))
  val updatedMap = map.mapValues {
    case innerMap: Map[_, _] => innerMap.mapValues {
      case count: Int => count * 2
      case other => other
    }
    case other => other
  }
  // Output: Map(fruit -> Map(apple -> 10, banana -> 6), color -> Map(red -> 4, yellow -> 8))

// return sum of [key.length * value]

  val map77 = Map("apple" -> 5, "banana" -> 3, "orange" -> 2)
  var result = 0

  for ((key, value) <- map77) {
    result += value * key.length
  }

  println(result)

  val map99 = Map("apple" -> 5, "banana" -> 3, "orange" -> 2)
  val result99 = map99.map { case (key, value) => value * key.length }.sum

  println(result99)
  // Output: 55

  val map88 = Map("apple" -> 5, "banana" -> 3, "orange" -> 2)
  val result88 = map88.foldLeft(0) { case (acc, (key, value)) => acc + (value * key.length) }

  println(result88)
  // Output: 31

  val sumlist = List(1,2,3,4).foldLeft(0)((accumulator, element) => accumulator + element)
    println(sumlist)
}
