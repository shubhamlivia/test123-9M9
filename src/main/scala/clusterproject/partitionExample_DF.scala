package clusterproject

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object partitionExample_DF extends App{

  val spark = SparkSession.builder
    .appName("All Partitioning methods")
    .master("local[*]")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  val data = Seq(
    ("John", "Sales", 5000),
    ("Jane", "Marketing", 6000),
    ("Mike", "Sales", 5500),
    ("Sara", "HR", 4500),
    ("David", "Marketing", 7000),
    ("Lisa", "HR", 4000)
  )

  import spark.implicits._

  val df = data.toDF("Name","Department","Salary")

  println(df.rdd.getNumPartitions)

  val bucketedDF = df.write
    .bucketBy(4, "Department")
    .sortBy("Name")
    .saveAsTable("bucketed_table") // Save the bucketed DataFrame as a table

   //Read the bucketed DataFrame
  val readBucketedDF = spark.table("bucketed_table")
  readBucketedDF.show()

  val x = readBucketedDF.orderBy("Department","Name")
  x.show(false)

 //  Apply partitioning on the DataFrame
  val partitionedDF = df
    .write
    .partitionBy("Department") // Specify the column(s) for partitioning
    .saveAsTable("partitioned_table") // Save the partitioned DataFrame as a table

  // Read the partitioned DataFrame
  val readPartitionedDF = spark.table("partitioned_table")
  readPartitionedDF.show()



}
