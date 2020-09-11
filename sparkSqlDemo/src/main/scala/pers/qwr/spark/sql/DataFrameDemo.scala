package pers.qwr.spark.sql

import org.apache.spark.sql.{Row, SparkSession}

object DataFrameDemo {

  def main(args: Array[String]) {
    // For implicit conversions like converting RDDs to DataFrames
    import spark.implicits._

    val df = sc.textFile("hdfs://node2:9000//user/root/people.txt").map { x => val para = x.split(","); (para(0), para(1).trim.toInt) }.toDF("name", "age")
    // Displays the content of the DataFrame to stdout
    df.show()

    df.filter($"age" > 21).show()

    df.createOrReplaceTempView("persons")

    spark.sql("SELECT * FROM persons WHERE age > 21").show()

    spark.stop()
  }
}
