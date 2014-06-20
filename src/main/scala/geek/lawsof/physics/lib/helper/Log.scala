package geek.lawsof.physics.lib.helper

import org.apache.logging.log4j.{Level, LogManager, Logger}
import geek.lawsof.physics.Reference

/**
 * Created by anshuman on 26-05-2014.
 */
object Log {
  var logger: Logger = LogManager.getLogger(Reference.MOD_ID)

  def apply(logLevel: Level, `object`: AnyRef) {
    logger.log(logLevel, `object`.toString)
  }

  def info(`object`: AnyRef) {
    logger.info(`object`.toString)
  }

  def debug(`object`: AnyRef) {
    logger.debug(`object`.toString)
  }

  def fatal(`object`: AnyRef) {
    logger.fatal(`object`.toString)
  }

  def error(`object`: AnyRef) {
    logger.error(`object`.toString)
  }

  def fatal(`object`: AnyRef, error: Throwable) {
    logger.fatal(`object`.toString, error)
  }

  def error(`object`: AnyRef, error: Throwable) {
    logger.error(`object`.toString, error)
  }

  def trace(`object`: AnyRef) {
    logger.trace(`object`.toString)
  }
}
