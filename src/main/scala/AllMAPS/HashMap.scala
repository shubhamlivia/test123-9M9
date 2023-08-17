/**
 * Usage: HashMap is a mutable implementation of the Map trait, providing efficient key-value lookups, insertions,
 * and deletions. It is suitable when you need a mutable map for dynamic updates.
When to implement: Use HashMap when you need a mutable map and performance is a concern.
 */
package AllMAPS

import scala.collection.mutable.HashMap

object HashMap {

  def main(args: Array[String]): Unit = {
    val hashMap = new HashMap[Int, String]
    hashMap.put(1,"Apple")
    hashMap.put(2, "Banana")
    hashMap.put(3, "Orange")

    println(hashMap)
    println(hashMap.get(4))
    hashMap.remove(3)
    println(hashMap)
    hashMap.put(2,"Mango")
    println(hashMap.get(2))

    for((key,value) <- hashMap)
      {
        println(s"$key, $value")
      }
  }
}
