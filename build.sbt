name := "test123"
version := "1.0"
scalaVersion := "2.11.12"

val sparkVersion = "2.4.7"


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion ,
  "org.apache.spark" %% "spark-sql" % sparkVersion ,
  "org.apache.spark" %% "spark-hive" % sparkVersion
)

libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.17.1"


unmanagedResourceDirectories in Compile += baseDirectory.value / "src" / "main" / "resources"
