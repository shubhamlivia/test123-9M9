import scala.collection.mutable

class Node(var data: Int, var next: Option[Node])

class LinkedList {
  var head: Option[Node] = None

  def add(data: Int): Unit = {
    val newNode = new Node(data, None)
    if (head.isEmpty) {
      head = Some(newNode)
    } else {
      var current = head
      while (current.get.next.isDefined) {
        current = current.get.next
      }
      current.get.next = Some(newNode)
    }
  }

  def apply(index: Int): Option[Int] = {
    var current = head
    var currentIndex = 0
    while (current.isDefined && currentIndex < index) {
      current = current.get.next
      currentIndex += 1
    }
    if (current.isDefined) Some(current.get.data) else None
  }

  def update(index: Int, data: Int): Boolean = {
    var current = head
    var currentIndex = 0
    while (current.isDefined && currentIndex < index) {
      current = current.get.next
      currentIndex += 1
    }
    if (current.isDefined) {
      current.get.data = data
      true
    } else {
      false
    }
  }

  def insert(index: Int, data: Int): Boolean = {
    if (index < 0) {
      false
    } else if (index == 0) {
      val newNode = new Node(data, head)
      head = Some(newNode)
      true
    } else {
      var current = head
      var currentIndex = 0
      while (current.isDefined && currentIndex < index - 1) {
        current = current.get.next
        currentIndex += 1
      }
      if (current.isDefined) {
        val newNode = new Node(data, current.get.next)
        current.get.next = Some(newNode)
        true
      } else {
        false
      }
    }
  }

  def remove(index: Int): Boolean = {
    if (index < 0 || head.isEmpty) {
      false
    } else if (index == 0) {
      head = head.get.next
      true
    } else {
      var current = head
      var currentIndex = 0
      while (current.isDefined && currentIndex < index - 1) {
        current = current.get.next
        currentIndex += 1
      }
      if (current.isDefined && current.get.next.isDefined) {
        current.get.next = current.get.next.get.next
        true
      } else {
        false
      }
    }
  }

  def display(): Unit = {
    var current = head
    while (current.isDefined) {
      print(current.get.data + " -> ")
      current = current.get.next
    }
    println("null")
  }
}

object Main extends App {
  val list = new LinkedList()
  list.add(1)
  list.add(2)
  list.add(3)

  list.display() // Output: 1 -> 2 -> 3 -> null

  println(list(1)) // Output: Some(2)

  list(1) = 4
  list.display() // Output: 1 -> 4 -> 3 -> null

  list.insert(1, 5)
  list.display() // Output: 1 -> 5 -> 4 -> 3 -> null

  list.remove(2)
  list.display() // Output: 1 -> 5 -> 3 -> null
}
