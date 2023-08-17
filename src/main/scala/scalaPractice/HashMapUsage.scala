package scalaPractice

import scala.collection.mutable.ArrayBuffer

object HashMapUsage extends App{

  val buf = new ArrayBuffer[Int]
  buf +=1
  buf +=2
  println(buf)

  3 +=: buf

  println(buf)

  import scala.collection.mutable.Queue

  val queue = new Queue[Int]()

  queue.enqueue(1)
  queue.enqueue(2)
  queue.enqueue(3)

  println(queue)

  val elements1 = queue.dequeue()
  //Queue and add elements to it using the enqueue method. We can then remove elements from the front of the queue
  // using the dequeue method.
//The elements are dequeued in the order they were enqueued, following a First-In-First-Out (FIFO) behavior.
  println(elements1)

  println(queue)

  import scala.collection.mutable.Stack

  val stack = new Stack[String]()

  //push elements onto the stack

  stack.push("Alice")
  stack.push("Bob")
  stack.push("Charlie")

  println(stack)
//Elements are added to the top of the stack, and we can remove elements from the top using the pop method.
// The elements are popped in the reverse order they were pushed, following a Last-In-First-Out (LIFO) behavior
  val ele1 = stack.pop()
  println(ele1)

  val text = "See Spot run. Run, Spot. Run!"
  val wordarray = text.split("[ !.,]+")
  println(wordarray.mkString(" "))

  var words = Set.empty[String]

  for(word <- wordarray)
    {
      words += word.toLowerCase(  )
    }

  println(words)

  //apporach 2

  val cleanText = text.replaceAll("[^a-zA-Z ]", "").toLowerCase
  println(cleanText)

  val individualwords = cleanText.split(" ")

  val wordcounts = individualwords.groupBy(identity).mapValues(x=> x.length)

  println(wordcounts)

  //approach 3

  val cleanText1 = text.replaceAll("[^a-zA-Z ]", "").toLowerCase
  val individualwords1 = cleanText.split(" ")
  val wordCounts12 = individualwords1.map(word => (word, individualwords1.count(_ == word))).toMap

  println(wordCounts12)

  //approach 3

  val wordCounts34 = individualwords.foldLeft(Map.empty[String, Int]) { (counts, word) =>
    counts + (word -> (counts.getOrElse(word, 0) + 1))
  }
}
