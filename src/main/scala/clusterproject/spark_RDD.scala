package clusterproject
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions._
import org.apache.spark.storage.StorageLevel

object spark_RDD extends App{

  System.setProperty("hadoop.home.dir", "F:\\bigdata\\hadoop-2.7.0")

  Logger.getLogger("org").setLevel(Level.ERROR)

  val spark = SparkSession.builder()
    .appName("SplitDataFrame")
    .master("local[*]")
    .getOrCreate()

  val sc = spark.sparkContext
  import spark.implicits._

  val data = Seq(
    ("a", "b", "c"),
    ("d", null, "f"),
    ("g", "h", null),
    ("p", "q", "r")
  )

  val df3 = sc.parallelize(Seq(
    ("a", "b", "c"),
    ("d", null, "f"),
    ("g", "h", null),
    ("p", "q", "r")
  )).toDF("C1", "C2", "C3")

  df3.show(false)

  val x = df3.na.fill("cha")
  x.show(false)

  val y =   df3.filter(row => !row.toSeq.exists(x => x== null))
  y.show(false)

  val data1 = sc.parallelize(Seq(("Alice",25), ("Bob",30),("Charlie",35), ("Dave",40)))

  val x1 = data1.filter(x => x._2 >30)

  println(x1.collect().mkString("\n"))

  case class Person(name: String, age:Int)

  val personDF = sc.parallelize(Seq(Person("Alice",25), Person("Bob",35), Person("Charlie", 35), Person("Bob",38), Person("Dave",40)))

  val aggregatedAgeData = personDF.map(x=> (x.name, x.age)).reduceByKey((x,y) => (x + y))

  //aggregatedAgeData.foreach(println)

  println(aggregatedAgeData.collect().mkString("\n"))


  val rdd1 = sc.parallelize(Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

  val mapoutput = rdd1.map(x => x * 2)

  println(mapoutput.collect().mkString("\n"))

  val sentences = sc.parallelize(List("Hello Scala", "Is it good programming language?"))
  val splitwords = sentences.map(x=> x.split(" "))

  splitwords.foreach(word => println(word.mkString("\n")))


  val flatMapoutput = sentences.flatMap(x=> x.split( " "))
  println(flatMapoutput.collect().mkString("\n"))

  val fruitRDD = sc.parallelize(Seq(
    (1, "apple,banana"),
    (2, "orange"),
    (3, "grape,kiwi,pineapple"),
    (1, "mango"),
    (2, "pear,grapefruit")
  ))

  val flatFruitRDD = fruitRDD.flatMapValues(x=> x.split(","))
  println(flatFruitRDD.collect().mkString("\n"))

  val rdd2 = sc.parallelize(Seq((1,"A"))).toDF("id","Letter")

  val result = rdd2.select("Letter", "id").show(false)


  val df = Seq(1,2,3).toDF("num")
  df.show(false)

  import org.apache.spark.sql.types._

  val smartphones = Seq(
    ("samsung", "galaxyS10", "android", Some(12)),
    ("iphone", "iphone13pro", "Apple", Some(13)),
    ("realme", "realme7", "android", None))

  val schema = StructType(Seq(
    StructField("make", StringType, nullable = true),
    StructField("model", StringType, nullable = true),
    StructField("platform", StringType, nullable = true),
    StructField("cameramegapixel", IntegerType, nullable = true)
  ))

  val rowRDD = spark.sparkContext.parallelize(smartphones).map { case (make, model, platform, cameramegapixel) =>
    val cameraValue = cameramegapixel.getOrElse(0)
    Row(make, model, platform, cameraValue)
  }

  val smartphonesDf = spark.createDataFrame(rowRDD, schema)

  smartphonesDf.show()



  val df9 = spark.read.format("csv").option("inferSchema",true)
    .load("data/somedata123.csv").toDF("name","model","platform","camerapixel")

  df9.show(false)

  /**
   *
   * aggregatebykey
   */

  val newdata = sc.parallelize(
    List(("apple", 1), ("banana", 2), ("apple", 3), ("banana", 4), ("orange", 5))
  )

  val aggbykey = newdata.aggregateByKey(0)(
    (acc, value) => acc +value,
    (acc1, acc2) => acc1 + acc2
  )

  aggbykey.foreach(println)





}

