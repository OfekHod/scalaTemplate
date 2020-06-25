package common

import common.math.Calculator
import common.settings.ConfigurationSettings
import org.apache.log4j.Logger

import lib.Lib

object Main {
  def main(args: Array[String]): Unit = {
    // this validate all configuration settings values as first thing.
    ConfigurationSettings.initialize()

    val logger = Logger.getLogger(this.getClass)
    logger.info("Common program has been started.")

    logger.info(Calculator.sum(5, 7, ConfigurationSettings.calculator))

    logger.info("Common program has been finished.")
  }
}
