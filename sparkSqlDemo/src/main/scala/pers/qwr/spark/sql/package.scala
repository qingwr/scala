package pers.qwr.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

package object sql {
  var sc = new SparkContext(new SparkConf().setAppName("mapFamily").setMaster("local[*]"))
  val sparkConf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
  val spark = SparkSession.builder().appName("Spark SQL basic example").config(sparkConf).getOrCreate()
  System.setProperty("hadoop.home.dir", "D:\\qwr\\tools\\bitData\\hadoop-2.7.1")
}
