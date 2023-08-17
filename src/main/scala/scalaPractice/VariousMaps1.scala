package scalaPractice

import scala.collection.mutable.HashMap
import scala.collection.mutable.HashTable

object VariousMaps1 extends App{
  val scores = HashMap("Alice" -> 90, "Bob" -> 80)
  scores("Alice")=99
  scores("Bob")=33
  println(scores)
  scores.remove("Bob")
  println(scores)

  val scores1 = Map("Alice" -> 90, "Bob" -> 80)
  val aliceScore = scores1("Alice") // Accessing value for key "Alice"
  println(scores1)
  val updatedScores = scores1 + ("Charlie" -> 85) // Adding a new key-value pair
  val filteredScores = updatedScores.filter { case (_, score) => score >= 85 } // Filtering based on a condition
  println(filteredScores)


}
