package com.hashtable.demo.hashtable.immutable

trait HashTable[K, V] {

  def insert(key: K, value: V) : HashTable[K,V]
// if we insert an immutable hash table, it needs to return a new complete hash table which will have our key.
  //it will return a complete hash table leaving the current hash table untouched.

  def search(key: K): Option[V]   //search is same, search does not modify our data structure

  def delete(key: K): HashTable[K,V]   //also need to return our HashTable again
}
