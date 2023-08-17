package clusterproject

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object RDD_DataFrame extends App{
  System.setProperty("hadoop.home.dir", "F:\\bigdata\\hadoop-2.7.0")

  Logger.getLogger("org").setLevel(Level.ERROR)

  val spark = SparkSession.builder()
    .appName("SplitDataFrame")
    .master("local[*]")
    .getOrCreate()

  val sc = spark.sparkContext
  import spark.implicits._

    val df1 = sc.parallelize(Seq((1, "Andrew", 3), (2, "Bob", 3), (3, "Charlie", 4), (4, "David", 1))).toDF("id1", "name", "id2")

  val joinedDF = df1.alias("a").join(df1.alias("b"), $"a.id2" === $"b.id1")

  val empDF = df1.select(col("id1").alias("empid"), col("name").alias("empname"))
  val managerDF = df1.select(col("id2").alias("empid"), col("name").alias("empmanager"))

  val resultDF = empDF.join(managerDF, empDF.col("empid") === managerDF.col("empid"), "left")

  resultDF.show()

  val outputDF = joinedDF.select($"a.name".alias("name"), $"b.name".alias("manager"))

  outputDF.show(false)




  val nums = sc.parallelize(List(1,2,3,4,5,6,7,8,9,10))
  val evenRdd = nums.filter(x=> x%2==0)
  val oddRdd = nums.filter(x=> x%2 !=0)

  println(evenRdd.collect.mkString(" "))
  println(oddRdd.collect.mkString(" "))

  val lines = sc.parallelize(List("Hello world", "spark is awesome", "Big data is the future... really?","scala is another programming language"))

  //val lines = sc.parallelize(List("Hello world"))
  val splitword = lines.map(x=> x.split(" "))

  val output = splitword.collect().foreach(arr => println(arr.mkString(" ")))



  val startswith = splitword.filter(x=> x.startsWith("a"))

  println(startswith.collect.mkString("\n"))

  val longwords = splitword.filter(x => x.length >5)

  println(splitword.collect().mkString("\n"))

  println(longwords.collect().mkString("\n"))

  val dataRDD = sc.textFile("data/stock.csv")

  val header = dataRDD.first()

  val stocksRDD = dataRDD.filter(row => row != header)

  val stockstuple = stocksRDD.map(x =>
  {
    val fields = x.split(",")
    val date = fields(0)
    val symbol = fields(1)
    val closingPrice = fields(2).toDouble
    (date, symbol, closingPrice)
  })

  println(stockstuple.collect().mkString("\n"))

  val filterstockRDD = stockstuple.filter(x=> x._2 == "GOOG")

  //println(filterstockRDD.collect().mkString("\n"))

  val groupedRDD = filterstockRDD.map(x=> (x._2,x._3)).reduceByKey((x,y) => (x + y))

  println(groupedRDD.collect().mkString("\n"))

  val x = sc.parallelize(Seq("chandra!@#$%^&*()kanth")).toDF("name")
  x.show(false)

  val y = x.withColumn("name", regexp_replace(col("name"),"[^a-zA-Z1-9]",""))
  y.show(false)

  val s = "a1-b1,a2-b2"

  val df = sc.parallelize(s.split(",").map(_.split("-")).map{ case Array(a, b) => (a, b) }).toDF("A", "B")

  df.show(false)






}
