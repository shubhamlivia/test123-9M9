/**
 * Usage: ConcurrentHashMap is a thread-safe implementation of the Map trait, designed for concurrent access.
 * It allows multiple threads to perform concurrent read and write operations on the map.
When to implement: Use ConcurrentHashMap when you require thread-safety and need to perform
concurrent updates and reads on the map.
 */
package AllMAPS

import java.util.concurrent.ConcurrentHashMap
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

object ConcurrentHashMap {
  def main(args: Array[String]): Unit = {
    val concurrentHashMap = new ConcurrentHashMap[Int, String]

    implicit val ec: ExecutionContext = ExecutionContext.global

    // Perform concurrent read and write operations
    val writeFuture = Future {
      for (i <- 1 to 1000) {
        concurrentHashMap.put(i, s"Value $i")
        Thread.sleep(10) // Simulate some processing time

      }
    }
    val readFuture = Future {
      for (i <- 1 to 1000) {
        val value = concurrentHashMap.get(i)
        println(s"Read key $i, value: $value")
        Thread.sleep(5) // Simulate some processing time
      }
    }

    // Wait for both futures to complete
    val combinedFuture = for {
      _ <- writeFuture
      _ <- readFuture
    } yield ()

    // Handle the completion of the futures
    combinedFuture.onComplete {
      case Success(_) =>
        println("All read and write operations completed.")
      case Failure(ex) =>
        println(s"An error occurred: ${ex.getMessage}")
    }

    // Block the main thread until both futures complete
    concurrent.Await.result(combinedFuture, concurrent.duration.Duration.Inf)


  }

}
