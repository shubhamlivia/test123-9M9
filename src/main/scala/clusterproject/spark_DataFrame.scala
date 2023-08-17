package clusterproject

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import org.apache.spark.storage.StorageLevel

object spark_DataFrame extends App{
  System.setProperty("hadoop.home.dir", "F:\\bigdata\\hadoop-2.7.0")

  Logger.getLogger("org").setLevel(Level.ERROR)

  val spark = SparkSession.builder()
    .appName("SplitDataFrame")
    .master("local[*]")
    .getOrCreate()

  val sc = spark.sparkContext
  import spark.implicits._

  val stockdata = spark.read.option("inferSchema",true).option("header",true).csv("data/anotherstocks.csv")
  stockdata.show(false)

  val dailyReturnDF = stockdata
    .select(col("date"),col("symbol"), ((col("close")-col("open"))/col("open")).alias("daily_return")*100)
    .toDF("date","symbol","daily_return")
  dailyReturnDF.show(false)

  dailyReturnDF.filter(col("daily_return")>1).show(false)


  val yearDF = dailyReturnDF.selectExpr("year(date)").alias("year")
  yearDF.show(false)

  val yearDF1 = dailyReturnDF.select(col("symbol"), substring(col("date"),2,4).as("year")).toDF("symbol", "year")


  val yearDF2 = dailyReturnDF.select(col("symbol"), regexp_extract(col("date"),"\\d{4}",0)).toDF("symbol", "year")

  yearDF2.show(false)

  val yearDF3 = dailyReturnDF.select(col("symbol"), $"symbol",'symbol)

  yearDF3.show(false)

  val df = Seq((1, "apple, banana"),(2, "orange"),(3, "grape, kiwi, pineapple")).toDF("id","fruits")
  val splitFruits = split(col("fruits"),",")

  val countFruits = df.select(col("id"), size(splitFruits).as("fruit_count"))
  countFruits.show(false)
  val countFruits1 = df.groupBy(col("id")).agg(sum(size(splitFruits)).as("fruit_count"))
  countFruits1.show(false)


  /**agg **/

  val df11 = Seq(
    (1, "Alice", 25,"F"), (2, "Bob", 30, "M"),
    (3, "Charlie", 35, "M"),
    (4, "David", 40, "M"),
    (5, "Emma", 28, "F"),
    (6, "Frank", 32, "M"),
    (7, "Grace", 37, "F"),
    (8, "Henry", 42, "M")).toDF("id","name","age","gender")

  df11.show(false)

  df11.groupBy(col("gender")).agg(avg(col("age"))).orderBy(col("gender").asc).show(false)

  val windowspec = Window.partitionBy(col("gender"))
    .orderBy(col("age"))
    .rowsBetween(Window.unboundedPreceding,Window.unboundedFollowing)

  val rownumwindow = row_number().over(Window.partitionBy(col("gender")).orderBy(col("age")))

  val genderAvgAge = avg(col("age")).over(windowspec)

  val result = df11.select("gender","age")
    .withColumn("avg_male_age", genderAvgAge)
    .withColumn("avg_female_age",genderAvgAge)
    .withColumn("row_num_male", rownumwindow)
    .withColumn("row_num_female", rownumwindow)
    .filter(col("row_num_male")===1 or col("row_num_female")===1)
    .filter("gender in ('M','F')")
    .selectExpr("gender","COALESCE(avg_male_age,avg_female_age)")

  result.show(false)

  val test = df11.withColumn("gender_age", avg(col("age")).over(Window.partitionBy(col("gender"))))
    .withColumn("row_num", row_number().over(Window.partitionBy(col("gender")).orderBy(col("gender"))))
    .where('row_num === 1).select("gender", "gender_age")



  test.show(false)

  val df22 = spark.read.format("csv").option("inferSchema", true)
    .load("data/nullData.csv").toDF("id", "name", "age", "gender")



  df22.show()
  val filledDF = df22.na.drop()

  filledDF.show(false)

  val df44 = Seq(
    (1, "Alice", 25, "F"),
    (2, "Bob", 30, "M"),
    (3, "Charlie", 35, "M"),
    (2, "Bob", 30, "M"),
    (4, "David", 40, "M"),
    (5, "Emma", 28, "F"),
    (6, "Frank", 32, "M"),
    (7, "Grace", 37, "F"),
    (8, "Henry", 42, "M"),
    (7, "Grace", 37, "F")
  ).toDF("id", "name", "age", "gender")

  df44.show(false)

  df44.dropDuplicates(Seq("gender")).show(false)

  import org.apache.spark.sql.functions._

  // Define the hardcoded data
  val data = Seq(
    (1, "Alice", Array("apple", "banana")),
    (2, "Bob", Array("orange", "pear")),
    (3, "Charlie", Array("grape", "mango")),
    (4, "David", Array("pineapple", "watermelon")),
    (5, "Emma", Array("kiwi", "peach")),
    (6, "Frank", Array("strawberry", "blueberry")),
    (7, "Grace", Array("cherry", "plum")),
    (8, "Henry", Array("raspberry", "blackberry"))
  )

  // Convert the hardcoded data into a DataFrame
  val dff = data.toDF("id", "name", "items")

  // Explode the items column
  val explodedDf = dff.select($"id", $"name", explode($"items").as("item"))

  // Display the resulting DataFrame
  explodedDf.show()


  val df55 =
    Seq(
      (1, "Alice", Array("apple", "banana")),
      (2, "Bob", Array("orange", "pear")),
      (3, "Charlie", Array("grape", "mango")),
      (4, "David", Array("pineapple", "watermelon")),
      (5, "Emma", Array("kiwi", "peach")),
      (6, "Frank", Array("strawberry", "blueberry")),
      (7, "Grace", Array("cherry", "plum")),
      (8, "Henry", Array("raspberry", "blackberry"))
    )

  val df55_1 = df55.toDF("id", "name", "items")

  val explodeDF = df55_1.select('id, 'name, explode('items))
  explodeDF.show(false)

  val df66 = spark.read.json("data/jsonfile.json")
  df66.show(false)


  val salesDataDF = spark.read
    .option("header", "true")
    .option("inferSchema", "true")
    .option("delimiter", "|")
    .csv("data/salesdata.csv")

  salesDataDF.show(false)

  val avgsales = salesDataDF.select(avg(trim(col("sales"))))
  avgsales.show(false)

  val countprofit = salesDataDF.select(count(col("profit")))
  countprofit.show(false)

  val sumprofit = salesDataDF.select(sum(col("profit")))
  sumprofit.show(false)

  val minsales = salesDataDF.select(min(col("sales")))
  minsales.show(false)

  salesDataDF.createOrReplaceTempView("sales_data")

  val avgsalesDF = spark.sql("select avg(sales) from sales_data")
  avgsalesDF.show(false)

  val profitCountDF = spark.sql("select count(profit) from sales_data")
  profitCountDF.show(false)

  val profitsumDF = spark.sql("select sum(profit) from sales_data")
  profitsumDF.show(false)

  val minSalesDF = spark.sql("select min(sales) from sales_data")
  minSalesDF.show(false)

  val maxSalesDF = spark.sql("select max(sales) from sales_data")
  maxSalesDF.show(false)

  val absoulteprofitDF = spark.sql("select abs(profit) from sales_data")
  absoulteprofitDF.show(false)

  val ceilsalesDF = spark.sql("select ceil(sales) from sales_data")
  ceilsalesDF.show(false)

  val df77 = spark.read.json("data/employees.json")
  df77.show(false)

  df77.createOrReplaceTempView("employees_data")

  val emp_details = spark.sql("select id, name, concat(name, ' ' , email), length(name), lower(name), upper(name), substring(email,1,6), trim(name), REGEXP_REPLACE(email, '\\.(.*)@', '@') from employees_data")
  emp_details.show(false)

  val df88_1 = spark.read.format("csv")
    .option("header", true)
    .option("inferSchema", true)
    .load("data/tableA.csv")
  df88_1.show(false)

  val df88_2 = spark.read.format("csv")
    .option("header", true)
    .option("inferSchema", true)
    .load("data/tableB.csv")
  df88_2.show(false)

  df88_1.createOrReplaceTempView("tableA")
  df88_2.createOrReplaceTempView("tableB")

  val innerjoin = spark.sql("select * from tableA inner join tableB on tableA.id=tableB.id")
  innerjoin.show(false)

  val leftouterjoin = spark.sql("select * from tableA left outer join tableB on tableA.id=tableB.id")
  leftouterjoin.show(false)

  val df99 = spark.read.format("csv")
    .option("header", true)
    .option("inferSchema", true)
    .load("data/sales_data.csv")
  df99.show(false)

  val saleswindowDF = df99.withColumn("x", sum(col("sales")).over(Window.partitionBy(col("region"), col("year")))).orderBy(col("region").asc, col("year").asc)
  saleswindowDF.show(false)

  df99.createOrReplaceTempView("sales_window")

  val saleswindowSQL = spark.sql("select region, year, sales, sum(sales) over (partition by region, year order by region, year asc) from sales_window")
  saleswindowSQL.show(false)

  /** calculate the average sales for each region over the past two years */

  val avgsales_twoyears = spark.sql("select region, year, sales, avg(sales) over(partition by region order by year asc rows between 1 preceding and current row) from sales_window")
  avgsales_twoyears.show(false)


  val avgsale_twoyears = spark.sql("SELECT year, AVG(sales) OVER (PARTITION BY region ORDER BY year ASC ROWS BETWEEN 1 PRECEDING AND CURRENT ROW) from sales_window")
  avgsale_twoyears.show(false)


  sc.setCheckpointDir("C://test")
  val myRdd = sc.parallelize(Seq(1, 2, 3, 4, 5))

  myRdd.partitions.size

  myRdd.persist(StorageLevel.MEMORY_AND_DISK)

  val df111 = spark.read.option("multiline", "true").option("mode","permissive").json("data/person.json")

    .select(col("a"), col("b"), explode_outer(col("c")).as("c"), col("p"))
    .select(col("a"), col("b"), col("c.d").as("c-d"), col("c.e").as("c-e"), col("p"))

  df111.printSchema()
  df111.show(false)


  val explodedDF = df111
    .selectExpr("a", "b", "explode_outer(c) as c", "p")
    .selectExpr("a", "b", "c.d", "c.e", "p")
  explodedDF.show()

  explodeDF.persist(StorageLevel.MEMORY_ONLY_2)


}
