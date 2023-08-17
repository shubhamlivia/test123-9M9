package scalaMAPS

import scala.collection.mutable.ListBuffer

// Book class
case class Book(title: String, isbn: Long)

// HashTable class using Separate Chaining
class SeparateChainingHashTable(size: Int) {
  private val table: Array[ListBuffer[Book]] = Array.fill(size)(ListBuffer.empty[Book])

  private def hashFunction(isbn: Long): Int = {
    (isbn % size).toInt
  }

  def insert(book: Book): Unit = {
    val index = hashFunction(book.isbn)
    table(index) += book
  }

  def retrieve(isbn: Long): Option[Book] = {
    val index = hashFunction(isbn)
    table(index).find(_.isbn == isbn)
  }

  def printTable(): Unit = {
    for (i <- 0 until size) {
      println(s"Bucket $i: ${table(i)}")
    }
  }
}

// HashTable class using Open Addressing (Linear Probing)
class OpenAddressingHashTable(size: Int) {
  private val table: Array[Option[Book]] = Array.fill(size)(None)

  private def hashFunction(isbn: Long): Int = {
    (isbn % size).toInt
  }

  def insert(book: Book): Unit = {
    val index = hashFunction(book.isbn)
    var currentIndex = index
    while (table(currentIndex).isDefined) {
      currentIndex = (currentIndex + 1) % size
    }
    table(currentIndex) = Some(book)
  }

  def retrieve(isbn: Long): Option[Book] = {
    val index = hashFunction(isbn)
    var currentIndex = index
    while (table(currentIndex).exists(_.isbn != isbn)) {
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
object LibraryManagementSystem extends App {
  val book1 = Book("The Great Gatsby", 9781451620933L)
  val book2 = Book("To Kill a Mockingbird", 9780061120084L)
  val book3 = Book("Pride and Prejudice", 9780141439518L)
  val book4 = Book("1984", 9781451620940L)

  // Separate Chaining
  println("Separate Chaining Hash Table:")
  val separateChainingTable = new SeparateChainingHashTable(10)
  separateChainingTable.insert(book1)
  separateChainingTable.insert(book2)
  separateChainingTable.insert(book3)
  separateChainingTable.printTable()

  val retrievedBook1 = separateChainingTable.retrieve(9781451620933L)
  println(s"Retrieved Book 1: $retrievedBook1")

  println()

  // Open Addressing
  println("Open Addressing Hash Table:")
  val openAddressingTable = new OpenAddressingHashTable(10)
  openAddressingTable.insert(book1)
  openAddressingTable.insert(book2)
  openAddressingTable.insert(book3)
  openAddressingTable.insert(book4)
  openAddressingTable.printTable()

  val retrievedBook2 = openAddressingTable.retrieve(9781451620933L)
  println(s"Retrieved Book 2: $retrievedBook2")
}
