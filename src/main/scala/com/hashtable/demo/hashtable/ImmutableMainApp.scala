package com.hashtable.demo.hashtable

object ImmutableMainApp {
  def main(args: Array[String]): Unit = {

    val table: immutable.HashTable[Int, String] = null

    // in immutable scenario, we have to be careful, we cannot just insert everything in the table as mutable scenario
    // because this creates a new record every time. So if you want to insert all these records at one go you could
    // just do this as follows

    val finaltable = table.insert(23423633, "Sam")
    .insert(45871412, "Joe")
    .insert(56784564, "Ruth")
    .insert(98837144, "Luis")

    println(s"This should be Sam", finaltable.search(23423633))
    println(s"This should be Joe", finaltable.search(45871412))
    println(s"This should be Ruth", finaltable.search(56784564))
    println(s"This should be Luis", finaltable.search(98837144))
    println(s"This should be None", finaltable.search(11111111))

    val removedJoe = finaltable.delete(45871412)   //immutable delete will create new hashtable.

    println(s"This should be None", removedJoe.search(45871412))
    println(s"This should be Joe", finaltable.search(45871412)) //original hashtable ie finaltable has Joe record.

  }
}
