package com.hashtable.demo.hashtable

import com.hashtable.demo.hashtable.mutable.HashTableImpl

object MutableMainApp {
  def main(args: Array[String]): Unit = {

    val table: mutable.HashTable[Int, String] = new HashTableImpl[Int, String](14)

    table.insert(23423633, "Sam")
    table.insert(19199245, "Krish")
    table.insert(20848053,"John")
    table.insert(19198979, "Arthur")
//    table.insert(45871412, "Joe")
//    table.insert(56784564, "Ruth")
//    table.insert(98837144, "Luis")

    println(s"This should be Sam", table.search(23423633))
    println(s"This should be Arthur", table.search(19198979))
//    println(s"This should be Ruth", table.search(56784564))
//    println(s"This should be Luis", table.search(98837144))
    println(s"This should be None", table.search(11111111))
//
    println(s"This should be Arthur", table.delete(19198979))
    println(s"This should be None", table.search(19198979))

  }

}
