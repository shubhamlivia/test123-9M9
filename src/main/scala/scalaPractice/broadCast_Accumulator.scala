package scalaPractice
import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.util.LongAccumulator

import java.sql.Timestamp
import java.time.LocalDateTime
object broadCast_Accumulator {

  System.setProperty("hadoop.home.dir", "F:\\bigdata\\hadoop-2.7.0")

  Logger.getLogger("org").setLevel(Level.ERROR)
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
      .setAppName("Accumulator_BroadcastExample")
      .setMaster("local[*]")
    val sc = new SparkContext(sparkConf)

    val accumulator:LongAccumulator = sc.longAccumulator("batchCountAccumulator")

    val batchSize = 10
    val data =  1 to 100
    val lookupData: Map[String, String] = Map("keys1" ->  "value1", "keys2" -> "value2")
      val broadcastVar = sc.broadcast(Option(lookupData))
    val result = sc.parallelize(data, 4).foreachPartition { partition =>
      val localBroadcastValue = broadcastVar.value
      partition.foreach { item =>
        localBroadcastValue.foreach { lookup =>
          println(s"Item: $item, Lookup: $lookup")
        }
        accumulator.add(1)
      }
    }
    println(s"Final Accumulator Value: ${accumulator.value}")

    val xTs = Some(Timestamp.valueOf(LocalDateTime.now()))
    println(xTs)
    sc.stop()
  }
}

