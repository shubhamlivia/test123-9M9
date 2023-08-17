package streaming

import org.apache.spark.sql.{DataFrame, SparkSession}


object StreamingDataframes extends App{
  System.setProperty("hadoop.home.dir", "F:\\bigdata\\hadoop-2.7.0")

  val spark = SparkSession.builder()
    .appName("streaming-1")
    .master("local[*]")
    .getOrCreate()

}
