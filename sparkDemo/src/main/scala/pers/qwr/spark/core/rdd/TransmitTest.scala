package pers.qwr.spark.core.rdd

import org.apache.spark.rdd.RDD
import pers.qwr.spark.core.sc

object TransmitTest {

  def main(args: Array[String]): Unit = {

    //1.初始化配置信息及SparkContext sc

    //2.创建一个RDD
    val rdd: RDD[String] = sc.parallelize(Array("hadoop", "spark", "hive", "atguigu"))

    //3.创建一个Search对象
    val search = new Search("hadoop ")

    //4.运用第一个过滤函数并打印结果
    val match1: RDD[String] = search.getMatche2(rdd)
    match1.collect().foreach(println)
  }
}