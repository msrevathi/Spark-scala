package Tavant.Learning.examples

import org.apache.spark.sql.SparkSession

object SparkMapPartitions {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder
      .master("local")
      .appName("DateFunctions")
      .getOrCreate()

    val data = spark.sparkContext.parallelize(List(1, 2, 3, 4, 5, 6, 7, 8), 2)
println("----------------")
    data.collect()
    def sumfuncpartition(numbers: Iterator[Int]): Iterator[Int] = {
      var sum = 0
      while (numbers.hasNext) {
        sum = sum + numbers.next()
      }
      return Iterator(sum)
    }

    data.mapPartitions(sumfuncpartition).collect()

  }
}
