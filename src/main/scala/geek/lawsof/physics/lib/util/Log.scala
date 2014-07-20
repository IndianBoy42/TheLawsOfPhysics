package geek.lawsof.physics.lib.util

import geek.lawsof.physics.Reference
import org.apache.logging.log4j.{Level, LogManager, Logger}

/**
 * Created by anshuman on 26-05-2014.
 */
object Log {
  var logger: Logger = LogManager.getLogger(Reference.MOD_ID)

  def apply(logLevel: Level, obj: AnyRef) {
    logger.log(logLevel, obj.toString)
  }

  def info(obj: AnyRef) {
    logger.info(obj.toString)
  }

  def debug(obj: AnyRef) {
    logger.debug(obj.toString)
  }

  def fatal(obj: AnyRef) {
    logger.fatal(obj.toString)
  }

  def error(obj: AnyRef) {
    logger.error(obj.toString)
  }

  def fatal(obj: AnyRef, error: Throwable) {
    logger.fatal(obj.toString, error)
  }

  def error(obj: AnyRef, error: Throwable) {
    logger.error(obj.toString, error)
  }

  def trace(obj: AnyRef) {
    logger.trace(obj.toString)
  }
}
