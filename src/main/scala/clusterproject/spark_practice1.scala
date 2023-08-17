package clusterproject


import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._

object spark_practice1 extends App{
  System.setProperty("hadoop.home.dir", "F:\\bigdata\\hadoop-2.7.0")

  Logger.getLogger("org").setLevel(Level.ERROR)

  val spark = SparkSession.builder()
    .appName("SplitDataFrame")
    .master("local[*]")
    .getOrCreate()

  val sc = spark.sparkContext
  import spark.implicits._

  val x = sc.parallelize(Seq(("GOOG", 12), ("AMAZON",10),("MICROSOFT",9),("GOOG",18)))
  x.map(x=> (x._1, x._2)).reduceByKey((x,y) => (x+y)).collect().foreach(println)

  val y = sc.parallelize(Seq(("GOOG", 12), ("AMAZON",10),("MICROSOFT",9),("GOOG",18))).toDF("symbol","price")
  y.groupBy(col("symbol")).agg(sum(col("price"))).orderBy(col("symbol")).show(false)

  /**
   * i have customer table order table. write a spark scala dataframe customers does not order any order?
   */

  // Sample data for customers (customer_id, customer_name, customer_email)

  val customersData = Seq(
    (1, "John Doe", "john.doe@example.com"),
    (2, "Jane Smith", "jane.smith@example.com"),
    (3, "Mike Johnson", "mike.johnson@example.com")
  )

  // Sample data for orders (order_id, customer_id, order_date, order_amount)
  val ordersData = Seq(
    (101, 1, "2023-07-01", 100.0),
    (102, 2, "2023-07-02", 150.0)
  )

  // Convert RDDs to DataFrames
  val customersRDD = sc.parallelize(customersData)
  val ordersRDD = sc.parallelize(ordersData)

  // Define the schema for customers and orders
  val customersSchema = List("customer_id", "customer_name", "customer_email")
  val ordersSchema = List("order_id", "customer_id", "order_date", "order_amount")

  import spark.implicits._

  val customersDF: DataFrame = customersRDD.toDF(customersSchema: _*)
  val ordersDF: DataFrame = ordersRDD.toDF(ordersSchema: _*)

  // Perform a left outer join between customers and orders on the customer_id column
  val joinedDF = customersDF
    .join(ordersDF, customersDF("customer_id") === ordersDF("customer_id"), "left_outer")

  // Filter the rows where order_id is null (meaning no order exists for that customer)
  val customersWithoutOrdersDF = joinedDF.filter(ordersDF("order_id").isNull)

  // Select only the columns from the customers table
  val resultDF = customersWithoutOrdersDF.select(customersDF("customer_id"), customersDF("customer_name"), customersDF("customer_email"))

  // Show the customers who haven't placed any orders
  resultDF.show()

}
