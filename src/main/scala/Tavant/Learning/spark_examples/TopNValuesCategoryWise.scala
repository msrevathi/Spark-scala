package Tavant.Learning.spark_examples

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
object TopNValuesCategoryWise {

  case class Employee(deptId: Int, empName: String, Salary: Long)
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.master("local").appName("Top N Values Category Wise").getOrCreate()


    import spark.implicits._

    val empDF = Seq(Employee(0,"Deepak",30900), Employee(0,"Abhishek",22100), Employee(0,"Manav",19600), Employee(0,"Preetam",13000),
      Employee(1,"Veeru",28500), Employee(1,"Vishwa",26800), Employee(1,"Vikas",126000), Employee(1,"Vibhav",53000),
      Employee(2,"Suhani",39600), Employee(2,"Smiley",29700), Employee(2,"Moni",27900), Employee(2,"Simran",98000),
      Employee(3,"Bani",35600)).toDF

    empDF.show(false)
/**Output Of empDetail DataFrame
+------+--------+------+
|deptId|empName |Salary|
+------+--------+------+
|0     |Deepak  |30900 |
|0     |Abhishek|22100 |
|0     |Manav   |19600 |
|0     |Preetam |13000 |
|1     |Veeru   |28500 |
|1     |Vishwa  |26800 |
|1     |Vikas   |126000|
|1     |Vibhav  |53000 |
|2     |Suhani  |39600 |
|2     |Smiley  |29700 |
|2     |Moni    |27900 |
|2     |Simran  |98000 |
|3     |Bani    |35600 |
+------+--------+------+
  **/

    val window1 = Window.partitionBy('deptId).orderBy('salary desc)

    val top_values_categoryWise = empDF.withColumn("rowNum" , row_number over(window1)).where('rowNum === 1).drop('rowNum).show(false)
    val top_values_categoryWise1 = empDF.withColumn("top_sal", max('salary)).filter('rowNum === 1).drop('rowNum).show(false)

    /**
      * +------+-------+------+
      * |deptId|empName|Salary|
      * +------+-------+------+
      * |1     |Vikas  |126000|
      * |3     |Bani   |35600 |
      * |2     |Simran |98000 |
      * |0     |Deepak |30900 |
      * +------+-------+------+
      */
  }
}
