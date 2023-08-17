package clusterproject
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object sparkPractise1 extends App{
  System.setProperty("hadoop.home.dir", "F:\\bigdata\\hadoop-2.7.0")

  Logger.getLogger("org").setLevel(Level.ERROR)

  val spark = SparkSession.builder()
    .appName("SplitDataFrame")
    .master("local[*]")
    .getOrCreate()

  val sc = spark.sparkContext

  import spark.implicits._

  val newdata = sc.parallelize(
    List(("apple", 1), ("banana", 2), ("apple", 3), ("banana", 4), ("orange", 5))
  )

  val aggbykey = newdata.aggregateByKey(0)(
    (acc,value) => acc + value, (acc1, acc2)=> acc1 + acc2
  )



}
