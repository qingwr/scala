package pers.qwr.spark

import org.apache.spark.{SparkConf, SparkContext}

package object core {
  var sc = new SparkContext(new SparkConf().setAppName("mapFamily").setMaster("local[*]"))
  val sparkConf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
  System.setProperty("hadoop.home.dir", "D:\\qwr\\tools\\bitData\\hadoop-2.7.1")
}
