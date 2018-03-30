package scalaTemplate

import scalaTemplate.math.Calculator
import scalaTemplate.settings.{ConfigurationSettings}
import org.apache.log4j.Logger


object Main {
  def main(args: Array[String]): Unit = {
    // this validate all configuration settings values as first thing.
    ConfigurationSettings.initialize()

    val logger = Logger.getLogger(this.getClass)
    logger.info("Pennywise program has been started.")

    println(Calculator.sum(5, 7, ConfigurationSettings.calculator))

    logger.info("Pennywise program has been finished.")
  }

}
