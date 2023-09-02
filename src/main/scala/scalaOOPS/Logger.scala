/**
 * Let's create a new use case where we implement the Singleton pattern using a Logger class
 */
package scalaOOPS

object Logger {
  private var instance: Logger = _

  def getInstance : Logger = {
    if(instance == null){
      synchronized {
        if(instance ==null){
          instance = new Logger
        }
      }
    }
    instance
  }

  def main(args: Array[String]): Unit = {
    val logger1 = Logger.getInstance
    val logger2 = Logger.getInstance
    println(logger1==logger2)
    logger1.log("This is a log message")
  }
}

class Logger private {
  def log (message: String):Unit = {
    println(s"Log: $message")
  }
}
