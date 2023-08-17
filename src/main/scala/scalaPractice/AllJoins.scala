package scalaPractice

import org.apache.spark.sql.SparkSession
import org.apache.log4j.Level
import org.apache.log4j.Logger


object AllJoins extends App{

  val spark = SparkSession.builder()
    .appName("ALL THE JOINS")
    .master("local")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")
  Logger.getRootLogger.setLevel(Level.ERROR)

  val sc = spark.sparkContext // for creating RDD through parallelize

  import org.apache.spark.sql.Row
  import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

  val kids = sc.parallelize(List(
    Row(40, "Mary", 1),
    Row(41, "Jane", 3),
    Row(42, "David", 3),
    Row(43, "Angela", 2),
    Row(44, "Charlie", 1),
    Row(45, "Jimmy", 2),
    Row(46, "Lonely", 7)
  ))

  val kidsSchema = StructType(Array(
    StructField("Id", IntegerType),
    StructField("Name",StringType),
    StructField("Team", IntegerType)
  ))

  val kidsDF = spark.createDataFrame(kids,kidsSchema)

  kidsDF.show(false)

  val teams = sc.parallelize(List(
    Row(1, "The Invincibles"),
    Row(2, "Dog Lovers"),
    Row(3, "Rockstars"),
    Row(4, "The Non-Existent Team")
  ))

  val teamsSchema = StructType(Array(
    StructField("TeamId", IntegerType),
    StructField("TeamName", StringType)
  ))

  val teamsDF = spark.createDataFrame(teams, teamsSchema)

  teamsDF.show(false)

  val joinCondition = kidsDF.col("Team") === teamsDF.col("TeamId")
  val kidsTeamsDF_Inner = kidsDF.join(teamsDF, joinCondition, "inner")
  val kidsTeamsDF_LeftOuter= kidsDF.join(teamsDF, joinCondition, "left_outer")
  val kidsTeamsDF_RightOuter= kidsDF.join(teamsDF, joinCondition, "right_outer")

  val kidsTeamsDF_LeftSemi= kidsDF.join(teamsDF, joinCondition, "left_semi")

  val kidsTeamsDF_LeftAnti= kidsDF.join(teamsDF, joinCondition, "left_anti")

}
