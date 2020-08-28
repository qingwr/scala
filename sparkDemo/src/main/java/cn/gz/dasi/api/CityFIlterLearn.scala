package cn.gz.dasi.api

import org.apache.spark.{SparkConf, SparkContext}

object CityFIlterLearn {

  def main(args: Array[String]): Unit = {
    groupByCityButton
  }

  def groupByCityButton(): Unit = {
    var sc = new SparkContext(new SparkConf().setAppName("mapPartitionsDemo").setMaster("local[*]"))
    //    val rdd = sc.makeRDD(Array("", ""))
    val rdd = sc.textFile("input").map(_.split(" "))

    sc.stop()
  }

}
