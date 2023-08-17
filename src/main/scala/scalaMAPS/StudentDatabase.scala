package scalaMAPS
/*
import scala.collection.mutable.ListBuffer

// Student class
case class Student(name: String, studentID: Int)

// HashTable class using Separate Chaining
class SeparateChainingHashTable(size: Int) {
  private val table: Array[ListBuffer[Student]] = Array.fill(size)(ListBuffer.empty[Student])

  private def hashFunction(studentID: Int): Int = {
    (studentID % size).toInt
  }

  def insert(student: Student): Unit = {
    val index = hashFunction(student.studentID)
    table(index) += student
  }

  def retrieve(studentID: Int): Option[Student] = {
    val index = hashFunction(studentID)
    table(index).find(_.studentID == studentID)
  }

  def printTable(): Unit = {
    for (i <- 0 until size) {
      println(s"Bucket $i: ${table(i)}")
    }
  }
}

// HashTable class using Open Addressing (Linear Probing)
class OpenAddressingHashTable(size: Int) {
  private val table: Array[Option[Student]] = Array.fill(size)(None)

  private def hashFunction(studentID: Int): Int = {
    (studentID % size).toInt
  }

  def insert(student: Student): Unit = {
    val index = hashFunction(student.studentID)
    var currentIndex = index
    while (table(currentIndex).isDefined) {
      currentIndex = (currentIndex + 1) % size
    }
    table(currentIndex) = Some(student)
  }

  def retrieve(studentID: Int): Option[Student] = {
    val index = hashFunction(studentID)
    var currentIndex = index
    while (table(currentIndex).exists(_.studentID != studentID)) {
      currentIndex = (currentIndex + 1) % size
      if (currentIndex == index) return None
    }
    table(currentIndex)
  }

  def printTable(): Unit = {
    for (i <- 0 until size) {
      println(s"Bucket $i: ${table(i)}")
    }
  }
}

// Main program
object StudentDatabase extends App {
  val student1 = Student("John Doe", 12345)
  val student2 = Student("Jane Smith", 67890)
  val student3 = Student("Emily Johnson", 54321)
  val student4 = Student("Michael Williams", 23456)
  val student5 = Student("Sarah Johnson", 62345)

  // Separate Chaining
  println("Separate Chaining Hash Table:")
  val separateChainingTable = new SeparateChainingHashTable(5)
  separateChainingTable.insert(student1)
  separateChainingTable.insert(student2)
  separateChainingTable.insert(student3)
  separateChainingTable.printTable()

  val retrievedStudent1 = separateChainingTable.retrieve(12345)
  println(s"Retrieved Student 1: $retrievedStudent1")

  println()

  // Open Addressing
  println("Open Addressing Hash Table:")
  val openAddressingTable = new OpenAddressingHashTable(5)
  openAddressingTable.insert(student1)
  openAddressingTable.insert(student2)
  openAddressingTable.insert(student3)
  openAddressingTable.insert(student4)
  openAddressingTable.insert(student5)
  openAddressingTable.printTable()

  val retrievedStudent2 = openAddressingTable.retrieve(12345)
  println(s"Retrieved Student 2: $retrievedStudent2")
}
*/