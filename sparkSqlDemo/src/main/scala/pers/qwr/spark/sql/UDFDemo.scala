package pers.qwr.spark.sql

object UDFDemo {
  def main(args: Array[String]) {
    // For implicit conversions like converting RDDs to DataFrames
    import spark.implicits._

    val df = sc.textFile("hdfs://node2:9000//user/root/people.txt").map { x => val para = x.split(","); (para(0), para(1).trim.toInt) }.toDF("name", "age")
    // Displays the content of the DataFrame to stdout
    df.show()

    df.createOrReplaceTempView("persons")

    //自定义UDF
    spark.udf.register("addName", (str: String) => "Name is " + str)
    //使用自定义UDF
    spark.sql("SELECT addName(name), age FROM persons ").show()

    //自定义弱类型聚合函数: MyAverage
    spark.udf.register("myAverage", MyAverage)
    spark.sql("SELECT myAverage(age) FROM persons ").show()

    //自定义强类型聚合函数: MyAverage2
    var ds = df.as[Employee]
    ds.select(MyAverage2.toColumn.name("average_age")).show

    spark.stop()
  }
}
