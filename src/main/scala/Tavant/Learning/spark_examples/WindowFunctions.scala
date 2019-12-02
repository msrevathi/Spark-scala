package Tavant.Learning.spark_examples

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._

case class Salary(deptName: String, empNo: Int, empName: String, salary: Long, skill: Seq[String])

object WindowFunctions {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder
      .master("local")
      .appName("Window Functions")
      .getOrCreate()

    import spark.implicits._
    //Creating a Dataset
    val empSalary = List(
      Salary("Admin", 21, "Katam", 50000, List("Spark", "Scala")),
      Salary("HR", 22, "Karanpreet", 39000, List("Hiring", "Scala")),
      Salary("Admin", 33, "Rakesh", 48000, List("Spark", "Scala")),
      Salary("Admin", 44, "Ravi", 48000, List("Spark", "Scala")),
      Salary("HR", 55, "Suhani", 35000, List("Hiring", "Scala")),
      Salary("IT", 71, "Deepak", 42000, List("Spark", "Scala")),
      Salary("IT", 81, "Veeru", 60000, List("Spark", "Python")),
      Salary("IT", 90, "Manav", 45000, List("Spark", "Java")),
      Salary("IT", 101, "Pritam", 52000, List("Spark", "Scala")),
      Salary("IT", 112, "Abhishek", 52000, List("Spark", "Python"))).toDS


    // empSalary.createTempView("empSalary")

//         empSalary.show()
//    println("-----------------empSalary-------------------")
      /* +--------+-----+----------+------+---------------+-----+-----+
      * |      HR|   22|Karanpreet| 39000|[Hiring, Scala]|35000| null|
      * |      HR|   55|    Suhani| 35000|[Hiring, Scala]|   NA|39000|
      * |   Admin|   21|     Katam| 50000| [Spark, Scala]|48000| null|
      * |   Admin|   33|    Rakesh| 48000| [Spark, Scala]|48000|50000|
      * |   Admin|   44|      Ravi| 48000| [Spark, Scala]|   NA|48000|
      * |      IT|   81|     Veeru| 60000|[Spark, Python]|52000| null|
      * |      IT|  101|    Pritam| 52000| [Spark, Scala]|52000|60000|
      * |      IT|  112|  Abhishek| 52000|[Spark, Python]|45000|52000|
      * |      IT|   90|     Manav| 45000|  [Spark, Java]|42000|52000|
      * |      IT|   71|    Deepak| 42000| [Spark, Scala]|   NA|45000|
      * +--------+-----+----------+------+---------------+-----+-----+
      */


    // Creating a Window over Department name
    val window1 = Window.partitionBy("deptName")

    /** * val df = empSalary.withColumn("average_salary_dept", array_contains('skill, "Spark") over window1)
      *df.show()
      *
      * array_contains gives error with window function
      *
      *org.apache.spark.sql.AnalysisException: Expression 'array_contains(skill#128, Spark)' not supported within a window function.;;
      *
      */

    // Getting the Average and total salary department Wise

    val avgAndTotalSalary = empSalary.withColumn("salaries", collect_list('salary) over (window1))
      .withColumn("avgSalaries", avg('salary) over window1)
      .withColumn("total_sal", sum('salary) over (window1))
      .select("deptName", "empNo", "empName", "salary", "salaries", "avgSalaries", "total_sal")


//        avgAndTotalSalary.show(false)
//    println("-----------------avgAndTotalSalary-------------------")
    /**
      * +--------+-----+----------+------+--------------------+------------------+---------+
      * |deptName|empNo|   empName|salary|            salaries|       avgSalaries|total_sal|
      * +--------+-----+----------+------+--------------------+------------------+---------+
      * |      HR|   22|Karanpreet| 39000|      [39000, 35000]|           37000.0|    74000|
      * |      HR|   55|    Suhani| 35000|      [39000, 35000]|           37000.0|    74000|
      * |   Admin|   21|     Katam| 50000|[50000, 48000, 48...|48666.666666666664|   146000|
      * |   Admin|   33|    Rakesh| 48000|[50000, 48000, 48...|48666.666666666664|   146000|
      * |   Admin|   44|      Ravi| 48000|[50000, 48000, 48...|48666.666666666664|   146000|
      * |      IT|   71|    Deepak| 42000|[42000, 60000, 45...|           50200.0|   251000|
      * |      IT|   81|     Veeru| 60000|[42000, 60000, 45...|           50200.0|   251000|
      * |      IT|   90|     Manav| 45000|[42000, 60000, 45...|           50200.0|   251000|
      * |      IT|  101|    Pritam| 52000|[42000, 60000, 45...|           50200.0|   251000|
      * |      IT|  112|  Abhishek| 52000|[42000, 60000, 45...|           50200.0|   251000|
      * +--------+-----+----------+------+--------------------+------------------+---------+
      */


    val window2 = Window.partitionBy("deptName").orderBy('salary desc)

    val avgAndTotalSalaryOrderedFrame = empSalary.withColumn("salaries", collect_list('salary) over window2)
      .withColumn("avg_salaries", avg('salary) over window2)
      .withColumn("total_salary", sum('salary) over window2)
      .select("deptName", "empNo", "empName", "salary", "salaries", "avg_salaries", "total_salary")

//    println("-----------------avgAndTotalSalaryOrderedFrame-------------------")
//     avgAndTotalSalaryOrderedFrame.show(false)

/*
+--------+-----+----------+------+-----------------------------------+------------------+------------+
|deptName|empNo|empName   |salary|salaries                           |avg_salaries      |total_salary|
+--------+-----+----------+------+-----------------------------------+------------------+------------+
|HR      |22   |Karanpreet|39000 |[39000]                            |39000.0           |39000       |
|HR      |55   |Suhani    |35000 |[39000, 35000]                     |37000.0           |74000       |
|Admin   |21   |Katam     |50000 |[50000]                            |50000.0           |50000       |
|Admin   |33   |Rakesh    |48000 |[50000, 48000, 48000]              |48666.666666666664|146000      |
|Admin   |44   |Ravi      |48000 |[50000, 48000, 48000]              |48666.666666666664|146000      |
|IT      |81   |Veeru     |60000 |[60000]                            |60000.0           |60000       |
|IT      |101  |Pritam    |52000 |[60000, 52000, 52000]              |54666.666666666664|164000      |
|IT      |112  |Abhishek  |52000 |[60000, 52000, 52000]              |54666.666666666664|164000      |
|IT      |90   |Manav     |45000 |[60000, 52000, 52000, 45000]       |52250.0           |209000      |
|IT      |71   |Deepak    |42000 |[60000, 52000, 52000, 45000, 42000]|50200.0           |251000      |
+--------+-----+----------+------+-----------------------------------+------------------+------------+
      */


    // get the top 3 salaries each department wise

    val top3SalariesDeptWise = empSalary.withColumn("Top_3_sal_dep", row_number() over window2)
      .filter('Top_3_sal_dep <= 3).drop("Top_3_sal_dep")

//     top3SalariesDeptWise.show(false)
//    println("-----------------top3SalariesDeptWise-------------------")
    /**
      * +--------+-----+----------+------+---------------+
      * |deptName|empNo|empName   |salary|skill          |
      * +--------+-----+----------+------+---------------+
      * |HR      |22   |Karanpreet|39000 |[Hiring, Scala]|
      * |HR      |55   |Suhani    |35000 |[Hiring, Scala]|
      * |Admin   |21   |Katam     |50000 |[Spark, Scala] |
      * |Admin   |33   |Rakesh    |48000 |[Spark, Scala] |
      * |Admin   |44   |Ravi      |48000 |[Spark, Scala] |
      * |IT      |81   |Veeru     |60000 |[Spark, Python]|
      * |IT      |101  |Pritam    |52000 |[Spark, Scala] |
      * |IT      |112  |Abhishek  |52000 |[Spark, Python]|
      * +--------+-----+----------+------+---------------+
      */
    // lead & lag

    val lead_lag = empSalary.withColumn("lead", (lead('salary, 1) over window2).cast("Int"))
      .withColumn("lag", (lag('salary, 1).over(window2)).cast("Int"))
    //      .withColumn("lead_w1", lead('salary, 1).over(window1))    // does not work because window should be ordered
    //        .withColumn("lag_w1", lag('salary,1).over(window1))


//    lead_lag.show(false)
//    println("-----------------lead_lag-------------------")
    /**
      * +--------+-----+----------+------+---------------+-----+-----+
      * |deptName|empNo|empName   |salary|skill          |lead |lag  |
      * +--------+-----+----------+------+---------------+-----+-----+
      * |HR      |22   |Karanpreet|39000 |[Hiring, Scala]|35000|null |
      * |HR      |55   |Suhani    |35000 |[Hiring, Scala]|null |39000|
      * |Admin   |21   |Katam     |50000 |[Spark, Scala] |48000|null |
      * |Admin   |33   |Rakesh    |48000 |[Spark, Scala] |48000|50000|
      * |Admin   |44   |Ravi      |48000 |[Spark, Scala] |null |48000|
      * |IT      |81   |Veeru     |60000 |[Spark, Python]|52000|null |
      * |IT      |101  |Pritam    |52000 |[Spark, Scala] |52000|60000|
      * |IT      |112  |Abhishek  |52000 |[Spark, Python]|45000|52000|
      * |IT      |90   |Manav     |45000 |[Spark, Java]  |42000|52000|
      * |IT      |71   |Deepak    |42000 |[Spark, Scala] |null |45000|
      * +--------+-----+----------+------+---------------+-----+-----+
      */

    val leadLagDiff = lead_lag.withColumn("higher_than_next", ('salary - 'lead).cast("Int"))
      .withColumn("lower_than_prev", ('lag - 'salary).cast("Int"))

//    leadLagDiff.show(false)
//    println("-----------------leadLagDiff-------------------")

    /**
      * +--------+-----+----------+------+---------------+-----+-----+----------------+---------------+
      * |deptName|empNo|empName   |salary|skill          |lead |lag  |higher_than_next|lower_than_prev|
      * +--------+-----+----------+------+---------------+-----+-----+----------------+---------------+
      * |HR      |22   |Karanpreet|39000 |[Hiring, Scala]|35000|null |4000            |null           |
      * |HR      |55   |Suhani    |35000 |[Hiring, Scala]|null |39000|null            |4000           |
      * |Admin   |21   |Katam     |50000 |[Spark, Scala] |48000|null |2000            |null           |
      * |Admin   |33   |Rakesh    |48000 |[Spark, Scala] |48000|50000|0               |2000           |
      * |Admin   |44   |Ravi      |48000 |[Spark, Scala] |null |48000|null            |0              |
      * |IT      |81   |Veeru     |60000 |[Spark, Python]|52000|null |8000            |null           |
      * |IT      |101  |Pritam    |52000 |[Spark, Scala] |52000|60000|0               |8000           |
      * |IT      |112  |Abhishek  |52000 |[Spark, Python]|45000|52000|7000            |0              |
      * |IT      |90   |Manav     |45000 |[Spark, Java]  |42000|52000|3000            |7000           |
      * |IT      |71   |Deepak    |42000 |[Spark, Scala] |null |45000|null            |3000           |
      * +--------+-----+----------+------+---------------+-----+-----+----------------+---------------+
      */
    /**
      * leadLagDiff.printSchema()
      * root
      * |-- deptName: string (nullable = true)
      * |-- empNo: integer (nullable = false)
      * |-- empName: string (nullable = true)
      * |-- salary: long (nullable = false)
      * |-- skill: array (nullable = true)
      * |    |-- element: string (containsNull = true)
      * |-- lead: integer (nullable = true)
      * |-- lag: integer (nullable = true)
      * |-- higher_than_next: integer (nullable = true)
      * |-- lower_than_prev: integer (nullable = true)
      */
    // REPLACE NULL VALUES using na function
    // works when the columns are of integer datatype ,coz replacing value is of type integer .i.e 0
    val replaceNullValues = leadLagDiff.na.fill(0)

//    replaceNullValues.show(false)
//    println("-----------------replaceNullValues-------------------")

    /**
      * +--------+-----+----------+------+---------------+-----+-----+----------------+---------------+
      * |deptName|empNo|empName   |salary|skill          |lead |lag  |higher_than_next|lower_than_prev|
      * +--------+-----+----------+------+---------------+-----+-----+----------------+---------------+
      * |HR      |22   |Karanpreet|39000 |[Hiring, Scala]|35000|0    |4000            |0              |
      * |HR      |55   |Suhani    |35000 |[Hiring, Scala]|0    |39000|0               |4000           |
      * |Admin   |21   |Katam     |50000 |[Spark, Scala] |48000|0    |2000            |0              |
      * |Admin   |33   |Rakesh    |48000 |[Spark, Scala] |48000|50000|0               |2000           |
      * |Admin   |44   |Ravi      |48000 |[Spark, Scala] |0    |48000|0               |0              |
      * |IT      |81   |Veeru     |60000 |[Spark, Python]|52000|0    |8000            |0              |
      * |IT      |101  |Pritam    |52000 |[Spark, Scala] |52000|60000|0               |8000           |
      * |IT      |112  |Abhishek  |52000 |[Spark, Python]|45000|52000|7000            |0              |
      * |IT      |90   |Manav     |45000 |[Spark, Java]  |42000|52000|3000            |7000           |
      * |IT      |71   |Deepak    |42000 |[Spark, Scala] |0    |45000|0               |3000           |
      * +--------+-----+----------+------+---------------+-----+-----+----------------+---------------+
      */
    val lead_lag_StringType = empSalary.withColumn("lead", (lead('salary, 1) over window2).cast("String"))
      .withColumn("lag", lag('salary, 1) over window2)

    /**
      * lead_lag_StringType.printSchema()
      * root
      * |-- deptName: string (nullable = true)
      * |-- empNo: integer (nullable = false)
      * |-- empName: string (nullable = true)
      * |-- salary: long (nullable = false)
      * |-- skill: array (nullable = true)
      * |    |-- element: string (containsNull = true)
      * |-- lead: string (nullable = true)
      * |-- lag: long (nullable = true)
      */
    // works when the datatype is of string type
//    println("-----------------replace_stringValuesUsingNa-------------------")
    val replace_stringValuesUsingNa = lead_lag_StringType.na.fill("NA").show(false)
    /**
      * +--------+-----+----------+------+---------------+-----+-----+
      * |deptName|empNo|empName   |salary|skill          |lead |lag  |
      * +--------+-----+----------+------+---------------+-----+-----+
      * |HR      |22   |Karanpreet|39000 |[Hiring, Scala]|35000|null |
      * |HR      |55   |Suhani    |35000 |[Hiring, Scala]|NA   |39000|
      * |Admin   |21   |Katam     |50000 |[Spark, Scala] |48000|null |
      * |Admin   |33   |Rakesh    |48000 |[Spark, Scala] |48000|50000|
      * |Admin   |44   |Ravi      |48000 |[Spark, Scala] |NA   |48000|
      * |IT      |81   |Veeru     |60000 |[Spark, Python]|52000|null |
      * |IT      |101  |Pritam    |52000 |[Spark, Scala] |52000|60000|
      * |IT      |112  |Abhishek  |52000 |[Spark, Python]|45000|52000|
      * |IT      |90   |Manav     |45000 |[Spark, Java]  |42000|52000|
      * |IT      |71   |Deepak    |42000 |[Spark, Scala] |NA   |45000|
      * +--------+-----+----------+------+---------------+-----+-----+
      */


    val remove_null_using_case = lead_lag.withColumn("higher_than_next", when('lead.isNull, 0).otherwise('salary - 'lead))
      .withColumn("lower_than_prevvv", when('lag.isNull, 0).otherwise('lag - 'salary))

//    remove_null_using_case.show(false)
//    println("-----------------remove_null_using_case-------------------")

    /**
      * +--------+-----+----------+------+---------------+-----+-----+----------------+-----------------+
      * |deptName|empNo|empName   |salary|skill          |lead |lag  |higher_than_next|lower_than_prevvv|
      * +--------+-----+----------+------+---------------+-----+-----+----------------+-----------------+
      * |HR      |22   |Karanpreet|39000 |[Hiring, Scala]|35000|null |4000            |0                |
      * |HR      |55   |Suhani    |35000 |[Hiring, Scala]|null |39000|0               |4000             |
      * |Admin   |21   |Katam     |50000 |[Spark, Scala] |48000|null |2000            |0                |
      * |Admin   |33   |Rakesh    |48000 |[Spark, Scala] |48000|50000|0               |2000             |
      * |Admin   |44   |Ravi      |48000 |[Spark, Scala] |null |48000|0               |0                |
      * |IT      |81   |Veeru     |60000 |[Spark, Python]|52000|null |8000            |0                |
      * |IT      |101  |Pritam    |52000 |[Spark, Scala] |52000|60000|0               |8000             |
      * |IT      |112  |Abhishek  |52000 |[Spark, Python]|45000|52000|7000            |0                |
      * |IT      |90   |Manav     |45000 |[Spark, Java]  |42000|52000|3000            |7000             |
      * |IT      |71   |Deepak    |42000 |[Spark, Scala] |null |45000|0               |3000             |
      * +--------+-----+----------+------+---------------+-----+-----+----------------+-----------------+
      */

    // getting running total (adding everything up to current row)
    val runnig_total = empSalary.withColumn("running_total", sum('salary) over window2)
    /*
     *runnig_total.show()
     *
 +--------+-----+----------+------+---------------+-------------+
 |deptName|empNo|   empName|salary|          skill|running_total|
 +--------+-----+----------+------+---------------+-------------+
 |      HR|   22|Karanpreet| 39000|[Hiring, Scala]|        39000|
 |      HR|   55|    Suhani| 35000|[Hiring, Scala]|        74000|
 |   Admin|   21|     Katam| 50000| [Spark, Scala]|        50000|
 |   Admin|   33|    Rakesh| 48000| [Spark, Scala]|       146000|
 |   Admin|   44|      Ravi| 48000| [Spark, Scala]|       146000|
 |      IT|   81|     Veeru| 60000|[Spark, Python]|        60000|
 |      IT|  101|    Pritam| 52000| [Spark, Scala]|       164000|
 |      IT|  112|  Abhishek| 52000|[Spark, Python]|       164000|
 |      IT|   90|     Manav| 45000|  [Spark, Java]|       209000|
 |      IT|   71|    Deepak| 42000| [Spark, Scala]|       251000|
 +--------+-----+----------+------+---------------+-------------+
     */


    // Applying Range Frame in Window

    val window3 = Window.partitionBy("deptName").rowsBetween(Window.currentRow, 1)
    val rangeFrame = empSalary
      .withColumn("total_salaries", collect_list('salary) over window2)
      .withColumn("total_sal_range_deptwise", sum('salary) over window3)

    /**
      * rangeFrame.show()
      * +--------+-----+----------+------+---------------+--------------------+------------------------+
      * |deptName|empNo|   empName|salary|          skill|      total_salaries|total_sal_range_deptwise|
      * +--------+-----+----------+------+---------------+--------------------+------------------------+
      * |      HR|   22|Karanpreet| 39000|[Hiring, Scala]|             [39000]|                   74000|
      * |      HR|   55|    Suhani| 35000|[Hiring, Scala]|      [39000, 35000]|                   35000|
      * |   Admin|   21|     Katam| 50000| [Spark, Scala]|             [50000]|                   98000|
      * |   Admin|   33|    Rakesh| 48000| [Spark, Scala]|[50000, 48000, 48...|                   96000|
      * |   Admin|   44|      Ravi| 48000| [Spark, Scala]|[50000, 48000, 48...|                   48000|
      * |      IT|   81|     Veeru| 60000|[Spark, Python]|             [60000]|                  112000|
      * |      IT|  101|    Pritam| 52000| [Spark, Scala]|[60000, 52000, 52...|                  104000|
      * |      IT|  112|  Abhishek| 52000|[Spark, Python]|[60000, 52000, 52...|                   97000|
      * |      IT|   90|     Manav| 45000|  [Spark, Java]|[60000, 52000, 52...|                   87000|
      * |      IT|   71|    Deepak| 42000| [Spark, Scala]|[60000, 52000, 52...|                   42000|
      * +--------+-----+----------+------+---------------+--------------------+------------------------+
      */

    // Applying Range Frame in Window with order

    val window4 = Window.partitionBy("deptName").orderBy('salary desc).rowsBetween(Window.currentRow, 1)
    val rangeFrameOrdered = empSalary
      .withColumn("total_salaries", collect_list('salary) over window2)
      .withColumn("total_sal_range_deptwise", sum('salary) over window3)

    /**
      * rangeFrameOrdered.show(false)
      * +--------+-----+----------+------+---------------+-----------------------------------+------------------------+
      * |deptName|empNo|empName   |salary|skill          |total_salaries                     |total_sal_range_deptwise|
      * +--------+-----+----------+------+---------------+-----------------------------------+------------------------+
      * |HR      |22   |Karanpreet|39000 |[Hiring, Scala]|[39000]                            |74000                   |
      * |HR      |55   |Suhani    |35000 |[Hiring, Scala]|[39000, 35000]                     |35000                   |
      * |Admin   |21   |Katam     |50000 |[Spark, Scala] |[50000]                            |98000                   |
      * |Admin   |33   |Rakesh    |48000 |[Spark, Scala] |[50000, 48000, 48000]              |96000                   |
      * |Admin   |44   |Ravi      |48000 |[Spark, Scala] |[50000, 48000, 48000]              |48000                   |
      * |IT      |81   |Veeru     |60000 |[Spark, Python]|[60000]                            |112000                  |
      * |IT      |101  |Pritam    |52000 |[Spark, Scala] |[60000, 52000, 52000]              |104000                  |
      * |IT      |112  |Abhishek  |52000 |[Spark, Python]|[60000, 52000, 52000]              |97000                   |
      * |IT      |90   |Manav     |45000 |[Spark, Java]  |[60000, 52000, 52000, 45000]       |87000                   |
      * |IT      |71   |Deepak    |42000 |[Spark, Scala] |[60000, 52000, 52000, 45000, 42000]|42000                   |
      * +--------+-----+----------+------+---------------+-----------------------------------+------------------------+
      */



    // Creating a ordered window on all the rows

val window5 = Window.partitionBy("depNtame").orderBy("salary").rowsBetween(Window.unboundedPreceding, Window.unboundedFollowing)

    // Getting Median

//val median = empSalary.withColumn("salaries", collect_list("salary") over window5)
//  .withColumn("median", element_at('salaries, (size('salaries)/2)+1).cast("Int"))

    // or

//    val median1 = empSalary.groupBy("deptname").agg(sort_array(collect_list('salary))).as("salaries")
//      .select('deptName, element_at('salaries, (size('salaries)/2)+1).cast("Int")).as("median")


    // broadcast join
//    val joinedMedianSalary = empSalary.join(broadcast(median), "deptName")
//      .select("deptName", "empNo", "empName", "salary", "salaries", "median_salary")
  }

}
