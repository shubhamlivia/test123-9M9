/**
 * Companion Objects:
when you create an object with the same class name as its companion.
The companion object has special access to the class and can be used to define static functions.

Have you ever wondered quite sometimes we dont specify "new" keyword on certain classes this is because you can
create "apply" functions in companion objects that act like a factory method.
val list = List(1,2,3)
 */
package com.hashtable.demo.hashtable.immutable

class HashTableImpl[K,V](hashVector: Vector[List[(K,V)]]) extends HashTable[K,V]   {

  override def insert(key: K, value: V): HashTable[K, V] = ???

  override def search(key: K): Option[V] = ???

  override def delete(key: K): HashTable[K, V] = ???
}

object HashTableImpl{
    def apply[K,V](initialSize:Int) ={
      val hashVector = Vector.fill(initialSize)(List())
      new HashTableImpl[K,V](hashVector)
    }
}
