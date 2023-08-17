package scalaMAPS
import scala.collection.mutable.LinkedList

object scalaHashTable extends App{

  class Employee(val id: Int, val name: String)

  class HashTable(size: Int) {

    private val hashTable: Array[LinkedList[Employee]] = Array.fill(size)(LinkedList.empty[Employee])

    private def hashFunction(key: Int): Int = key % size

    // Separate Chaining
    def separateChainingInsert(employee: Employee): Unit = {
      val hashKey = hashFunction(employee.id)
      hashTable(hashKey) = hashTable(hashKey) :+ employee
    }

    // Open Addressing with Linear Probing
    def openAddressingInsert(employee: Employee): Unit = {
      var hashKey = hashFunction(employee.id)
      var index = hashKey

      while (hashTable(index).nonEmpty) {
        index = (index + 1) % size
        if (index == hashKey)
          throw new Exception("Hash table is full")
      }

      hashTable(index) = LinkedList(employee)
    }

    def searchEmployeeById(id: Int): Option[Employee] = {
      val hashKey = hashFunction(id)
      hashTable(hashKey).find(_.id == id)
    }
  }

  // Usage Example
  val hashTable = new HashTable(5)

  // Employee records
  val employee1 = new Employee(101, "John")
  val employee2 = new Employee(102, "Emily")
  val employee3 = new Employee(201, "Michael")
  val employee4 = new Employee(103, "Sarah")
  val employee5 = new Employee(202, "David")

  // Separate Chaining
  hashTable.separateChainingInsert(employee1)
  hashTable.separateChainingInsert(employee2)
  hashTable.separateChainingInsert(employee3)
  hashTable.separateChainingInsert(employee4)
  hashTable.separateChainingInsert(employee5)

  // Open Addressing
  hashTable.openAddressingInsert(employee1)
  hashTable.openAddressingInsert(employee2)
  hashTable.openAddressingInsert(employee3)
  hashTable.openAddressingInsert(employee4)
  hashTable.openAddressingInsert(employee5)

  // Searching employee by ID
  val searchId = 102
  val employee = hashTable.searchEmployeeById(searchId)
  employee match {
    case Some(emp) => println(s"Employee found: ID=${emp.id}, Name=${emp.name}")
    case None => println(s"Employee with ID $searchId not found.")
  }


}
