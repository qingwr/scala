package cn.gz.dasi.local

import org.apache.spark.{SparkConf, SparkContext}

object ToHdfs {
  def main(args: Array[String]): Unit = {
    readHdfs
  }

  def readHdfs(): Unit = {
    var sc = new SparkContext(new SparkConf().setAppName("mapDemo").setMaster("local"))
    System.setProperty("hadoop.home.dir", "D:\\qwr\\tools\\bitData\\hadoop-2.7.1")
    var rdd = sc.textFile("hdfs://node1:9000//user/root/input").map(_ + " 来单挑哎呀").collect
    rdd.foreach(println)
    sc.stop()
  }

}
