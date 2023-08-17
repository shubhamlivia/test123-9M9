/**
 * Usage: LinkedHashMap is a mutable implementation of the Map trait
 * that maintains the insertion order of key-value pairs. It is useful when you need a mutable map
 * that preserves the order of insertion.
When to implement: Use LinkedHashMap when you require a mutable map with predictable iteration order based on insertion
 */
package AllMAPS

import scala.collection.mutable

object LinkedHashMap {
  def main(args: Array[String]): Unit = {
    val linkedHashMap = new mutable.LinkedHashMap[Int, String]

    linkedHashMap.put(8,"Grape")
    linkedHashMap.put(2,"Onion")
    linkedHashMap.put(7,"Tomoto")
    linkedHashMap.put(1,"Mango")

    println(linkedHashMap)

    println(linkedHashMap.get(1))
    println(linkedHashMap.get(4))

    linkedHashMap.update(7,"Spinach")
    println(linkedHashMap.get(1))

    linkedHashMap.remove(3)
    println(linkedHashMap.get(3))

    for ((key, value) <- linkedHashMap) {
      println(s"Key: $key, Value: $value")
    }

  }
}
