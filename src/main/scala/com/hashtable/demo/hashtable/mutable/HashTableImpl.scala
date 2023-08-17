package com.hashtable.demo.hashtable.mutable

class HashTableImpl[K,V](initialize : Int) extends HashTable[K, V] {

  private val hashArray = Array.fill(initialize)(List[(K,V)]())

  def hash[K](key: K) = {
    val h = key.## % initialize
    println("h: " + h)
    if(h <0 ) h + initialize else h
  }

  override def insert(key: K, value: V) :Unit  = {
    val list = hashArray( hash(key))
    println("1: " + list)
    hashArray(hash(key)) = (key,value)   +: list.filter(t => t._1 != key)
    println(hashArray.mkString(","))
  }

  override def search(key: K): Option[V] = {
    val list = hashArray( hash(key))
    list.find(t => t._1==key).map(t => t._2)
  }



  override def delete(key: K): Option[V] = {
    val list = hashArray( hash(key))
    hashArray(hash(key)) = list.filter(t => t._1 != key)
    list.find(t => t._1==key).map(t => t._2)
  }
}
