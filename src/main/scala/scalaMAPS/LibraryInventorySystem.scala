package scalaMAPS

//import scala.collection.mutable.ListBuffer
//
//// Book class to hold book information
//case class Book(title: String, borrower: String)
//
//// HashTable class using separate chaining
//class HashTable(size: Int) {
//  private val table: Array[ListBuffer[Book]] = Array.fill(size)(ListBuffer.empty[Book])
//
//  // Hash function
//  private def hash(key: String): Int = {
//    key.foldLeft(0)((acc, char) => acc + char.toInt) % size
//  }
//
//  // Insert a book into the hash table
//  def insert(book: Book): Unit = {
//    val index = hash(book.title)
//    table(index) += book
//  }
//
//  // Retrieve the borrower of a book
//  def getBorrower(title: String): Option[String] = {
//    val index = hash(title)
//    table(index).find(_.title == title).map(_.borrower)
//  }
//}
//
//object LibraryInventorySystem {
//  def main(args: Array[String]): Unit = {
//    val hashTable = new HashTable(10)
//
//    // Adding books to the hash table
//    hashTable.insert(Book("The Great Gatsby", "John"))
//    hashTable.insert(Book("To Kill a Mockingbird", "Emily"))
//    hashTable.insert(Book("Pride and Prejudice", "Sarah"))
//
//    // Retrieving borrower information
//    val borrower1 = hashTable.getBorrower("To Kill a Mockingbird")
//    val borrower2 = hashTable.getBorrower("The Great Gatsby")
//
//    // Printing borrower information
//    borrower1.foreach(b => println(s"Borrower of 'To Kill a Mockingbird': $b"))
//    borrower2.foreach(b => println(s"Borrower of 'The Great Gatsby': $b"))
//  }
//}

