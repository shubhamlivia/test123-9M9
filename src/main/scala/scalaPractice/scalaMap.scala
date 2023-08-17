package scalaPractice

object scalaMap extends App{
  val nums = List(1,2,3,4,5)
  val doubleNums = nums.map(x=> x *2)

  val doubleNums1 = nums.flatMap(x=> List(x * 2))
  println(doubleNums1)

  val names = List("Alice","Bob","Charlie")
  val uppercased = names.map(x=>(x, x.length))
  println(uppercased)

  case class Person(name:String, age:Int)
  val people = List(Person("Alice",25))
  val names11 = people.map(x=> x.name)
  println(names11)

  val nums22 = List(1,2,3,4,5)

  println(transformed) // Output: List((3, "1"), (5, "2"), (7, "3"), (9, "4"), (11, "5"))

  val transformed = nums22.map(x=> (x*2 +1, "\"" + x.toString + "\""))
  println(transformed)

  val numbers11 = List(1, 2, 3)
  val letters11 = List("A", "B", "C")

  val combined = numbers11.indices.map(x=> s"${letters11(x)}${numbers11(x)}").toList
  println(combined)

  val combined1 = letters11.zipWithIndex.map{case(l, i) => s"$l${numbers11(i)}"}
  println(combined1)

  //conditional transformations.
  val numbers = List(1, 2, 3, 4, 5)
  val transformed11 = numbers.map{x=> if(x%2==0) x*2 else x}
  println(transformed11)

  val words = List("apple", "banana", "cherry")

  val indexed = words.zipWithIndex.map{case(words, index) => s"$index: $words"}
  println(indexed)

  val countries = Map("US" -> "United States", "UK" -> "United Kingdom")

  val countrymap = countries.map{case(key, value) => key -> value}
  println(countrymap)

  //Chaining multiple map operation
  val nums123 = List(1,2,3)

  val manymap = nums123.map(_ + 1)

  /**
   * Map exercises
   */
  val nums70 = Map("a" -> 1, "b" -> 2, "c" -> 3)
  val mapdouble = nums70.map{case(key, value)=> ( key, value*2)}
  val mapdouble1 = nums70.mapValues(x=> x*2)

  println(mapdouble)
  println(mapdouble1)

  val nums71 = List(("a",1),("b",2),("c",3))
  val output71 = nums71.map{case (x,y) => y *2}

  println(output71)

  val nums72 = Map("a" -> 1, "b" -> 2, "c" -> 3)
  val evevMultiply = nums72.filter{case(_,value)=> value%2==0}.mapValues(x=> x*2)
  println(evevMultiply)

  val fruits = List("apple", "banana", "apple", "orange", "banana")
  val occurances = fruits.groupBy(identity).mapValues(x=> x.size)

  //The identity function is a function that returns its input unchanged. It serves as a convenient way to pass a function
  // that acts as the identity operation, meaning it returns the same value that is passed to it.

  //In this code, fruits.groupBy(identity) groups the elements of the fruits list by their identity, which essentially means grouping them
  // by their own values. Since the identity function returns each element unchanged, it acts as a grouping criterion that ensures
  // elements with the same value are grouped together.
  println(occurances)

  //Merging two maps

  val map1 = Map("a" -> 1, "b" -> 2)
  val map2 = Map("b" -> 3, "c" -> 4)

  val merged1234 = map1 ++ map2.map{case(key,value) => key -> (value + map1.getOrElse(key,0))}
  println(merged1234)

  val data123 = Map("A" -> List(1, 2, 3), "B" -> List(4, 5, 6))
  val xyz123 = data123.flatMap{case(key,value)=> value}
  println(xyz123)

  val data32 = Map("a" -> 1, "b" -> 2, "c" -> 3)
  val mapoutput123 = data32.map {case(key,value)=> (key.toUpperCase(), value*2)}
  println(mapoutput123)

  val data9 = Map("a" -> 1, "b" -> 2, "c" -> 3)
  val o1 = data9.filter{case(key,value) => key !="b" && value >1}
  println(o1)

  val data8 = Map("b" -> 2, "a" -> 1, "c" -> 3)
  val sortedMap = data8.toSeq.sortBy(x=> x._1).toMap
  println(sortedMap)

  //aggregate based on key.

  val data6 = List(("a", 1), ("b", 2), ("a", 3), ("b", 4))
  val aggbasedkey = data6.groupBy(x=> x._1).map{case(key,tuples)=> key -> tuples.map(x=> x._2).sum}
  println(aggbasedkey)

}
