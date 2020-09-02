package Tavant.Learning.spark_examples

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object DateFunctions {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder
      .master("local")
      .appName("DateFunctions")
      .getOrCreate()

    // Creating a dataFrame with Current date and current timestamp

    val dateDF = spark.range(10).withColumn("today", current_date())
      .withColumn("now", current_timestamp())

    /*
     *dateDF.show(false)
     * +---+----------+-----------------------+
|id |today     |now                    |
+---+----------+-----------------------+
|0  |2019-09-10|2019-09-10 00:54:01.314|
|1  |2019-09-10|2019-09-10 00:54:01.314|
|2  |2019-09-10|2019-09-10 00:54:01.314|
|3  |2019-09-10|2019-09-10 00:54:01.314|
|4  |2019-09-10|2019-09-10 00:54:01.314|
|5  |2019-09-10|2019-09-10 00:54:01.314|
|6  |2019-09-10|2019-09-10 00:54:01.314|
|7  |2019-09-10|2019-09-10 00:54:01.314|
|8  |2019-09-10|2019-09-10 00:54:01.314|
|9  |2019-09-10|2019-09-10 00:54:01.314|
+---+----------+-----------------------+
     */
    // dateDF.createGlobalTempView("dateTable")
    val date_sub_add = dateDF.select(date_sub(col("today") , 3), date_add(col("today"), 3))

    /**
      * date_sub_add.show(false)
      * +------------------+------------------+
      * |date_sub(today, 3)|date_add(today, 3)|
      * +------------------+------------------+
      * |2019-09-07        |2019-09-13        |
      * |2019-09-07        |2019-09-13        |
      * |2019-09-07        |2019-09-13        |
      * |2019-09-07        |2019-09-13        |
      * |2019-09-07        |2019-09-13        |
      * |2019-09-07        |2019-09-13        |
      * |2019-09-07        |2019-09-13        |
      * |2019-09-07        |2019-09-13        |
      * |2019-09-07        |2019-09-13        |
      * |2019-09-07        |2019-09-13        |
      * +------------------+------------------+
       */

    val dateDif = dateDF.withColumn("week_ago", date_sub(col("today"), 7))
      .select(datediff(col("today"), col("week_ago"))) //.show()
    /**
      * +-------------------------+
      * |datediff(today, week_ago)|
      * +-------------------------+
      * |                        7|
      * |                        7|
      * |                        7|
      * |                        7|
      * |                        7|
      * |                        7|
      * |                        7|
      * |                        7|
      * |                        7|
      * |                        7|
      * +-------------------------+
      */
    val monthsDif = dateDF.select(to_date(lit("2019-01-01")).alias("start"), to_date(lit("2019-07-01")).alias("end"))
      .select(months_between(col("start"), col("end")))//.show()

    /**
      *
    +--------------------------+
|months_between(start, end)|
+--------------------------+
|                      -6.0|
|                      -6.0|
|                      -6.0|
|                      -6.0|
|                      -6.0|
|                      -6.0|
|                      -6.0|
|                      -6.0|
|                      -6.0|
|                      -6.0|
+--------------------------+
      */
    val dateFormat = "yyyy-dd-MM"
    val cleanDateDF = spark.range(2).select(to_date(lit("2017-12-11"), dateFormat).alias("date"),to_date(lit("2017-20-12"), dateFormat).alias("date2"))//.show()

    /**
      * /*
      * +----------+----------+
      * |      date|     date2|
      * +----------+----------+
      * |2017-11-12|2017-12-20|
      * |2017-11-12|2017-12-20|
      * +----------+----------+
      **/
      */
   // cleanDateDF.select(to_timestamp(col("date"))).show()

    val timeStamp = cleanDateDF.select(to_timestamp(col("date"))).show(false)

    /**
      * +--------------------+
      * |to_timestamp(`date`)|
      * +--------------------+
      * |2017-11-12 00:00:00 |
      * |2017-11-12 00:00:00 |
      * +--------------------+
      */
  }


}
