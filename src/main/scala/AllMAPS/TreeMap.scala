/**
 * Usage: TreeMap is an immutable implementation of the SortedMap trait, maintaining key-value pairs in sorted order
 * based on the keys. It is suitable when you require a map with ordered key-value pairs.
  When to implement: Use TreeMap when you need a sorted map with efficient key lookup, insertion, and deletion operations.
 */
package AllMAPS

import scala.collection.immutable.TreeMap

object TreeMap {
  def main(args: Array[String]): Unit = {
    // Create a new TreeMap
    var treeMap = new TreeMap[Int, String]

    // Insert key-value pairs into the TreeMap
    treeMap += (3 -> "Apple")
    treeMap += (1 -> "Banana")
    treeMap += (2 -> "Orange")

    // Access values using keys
    println(treeMap.get(1)) // Output: Some(Banana)
    println(treeMap.get(4)) // Output: None

    // Update the value associated with a key
    treeMap += (2 -> "Mango")
    println(treeMap.get(2)) // Output: Some(Mango)

    // Remove a key-value pair from the TreeMap
    treeMap -= 3
    println(treeMap.get(3)) // Output: None

    // Iterate over key-value pairs in the TreeMap
    for ((key, value) <- treeMap) {
      println(s"Key: $key, Value: $value")
    }

  }
}
