package cn.gz.dasi.local

import org.apache.spark.{SparkConf, SparkContext}

object ToLocal {

  def main(args: Array[String]): Unit = {
    readLocal
  }

  def readLocal(): Unit = {
    var sc = new SparkContext(new SparkConf().setAppName("mapDemo").setMaster("local"))
    System.setProperty("hadoop.home.dir", "D:\\qwr\\tools\\bitData\\hadoop-2.7.1")
    var rdd = sc.textFile("input").map(_ + " 来单挑哎呀").collect
    rdd.foreach(println)
    sc.stop()
  }
}
