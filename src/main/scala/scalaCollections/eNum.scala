package scalaCollections

import org.apache.log4j.{LogManager, Logger}

object LoggerUtil {
  @transient private lazy val logger: Logger = LogManager.getLogger(getClass.getName)

  def getLogger: Logger = logger
}

object eNum extends _root_.scala.Enumeration {
  type eNum = _root_.scala.Predef.String
  val INITIAL_STATUS: _root_.java.lang.String = "test"

  def main(args: Array[String]): Unit = {
    val logger = LoggerUtil.getLogger

    // Log different levels of messages
    logger.trace("This is a trace message")
    logger.debug("This is a debug message")
    logger.info("This is an info message")
    logger.warn("This is a warning message")
    logger.error("This is an error message")
    logger.fatal("This is a fatal message")
    println(eNum.INITIAL_STATUS)
  }
}


