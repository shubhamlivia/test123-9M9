package clusterproject
import org.apache.spark.sql.SparkSession

object RangPartition extends App{

  import org.apache.spark.sql.functions._
  import org.apache.spark.sql.SparkSession

  val spark = SparkSession.builder()
    .appName("RangePartitioningExample")
    .master("local")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  // Create a sample DataFrame
  val data = Seq(
    ("John", 25),
    ("Alice", 30),
    ("Bob", 35),
    ("Charlie", 40),
    ("Eve", 45),
    ("Frank", 50)
  )

  val df = data.toDF("Name", "Age")
  df.show()

  // Define the age ranges for partitioning
  val ageRanges = Array(0, 30, 40, 50, 100)

 // val ageRanges = Array(lit(0), lit(30), lit(40), lit(50), lit(100))

  // Perform range partitioning based on the "Age" column
  val partitionedDF = df.repartitionByRange((ageRanges.map(lit) :+ col("Age")): _*)
  partitionedDF.show()
}
