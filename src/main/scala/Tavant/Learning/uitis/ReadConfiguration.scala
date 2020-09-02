package Tavant.Learning.uitis

import java.util.Properties

import org.apache.spark.sql.SparkSession

import com.typesafe.config.{Config, ConfigFactory}

object ReadConfiguration extends App {

  val config: Config = ConfigFactory.load("src/main/resources/application.conf")
  println(config.getString("input"))
}
