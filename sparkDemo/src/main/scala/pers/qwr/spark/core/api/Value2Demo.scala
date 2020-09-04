package pers.qwr.spark.core.api

/**
  * rdd 双value常用算子练习实例
  **/

import pers.qwr.spark.core.sc

object Value2Demo {
  def main(args: Array[String]): Unit = {
    //    unionDemo
    //    substract
    //    intersectionDemo
    //    cartesian
    zipDemo
    sc.stop
  }

  /**
    * 两个RDD,求合集
    **/
  def unionDemo() = {
    val rdd1 = sc.parallelize(1 to 5)
    val rdd2 = sc.parallelize(5 to 10)
    rdd1.foreach(x => print(x + "\t"))
    rdd2.foreach(x => print(x + "\t"))
    rdd1.union(rdd2).foreach(print)
  }

  /**
    * 差集
    * 第一个rdd有而第二rdd没有
    **/
  def substract() = {
    val rdd1 = sc.parallelize(1 to 5)
    val rdd2 = sc.parallelize(5 to 10)
    rdd2.subtract(rdd1).foreach(print)
  }

  /**
    * 交集
    * 两个rdd都有
    **/
  def intersectionDemo() = {
    val rdd1 = sc.parallelize(1 to 5)
    val rdd2 = sc.parallelize(5 to 10)
    rdd1.intersection(rdd2).foreach(print)
  }

  //  笛卡尔积 两个rdd所有元素组合（尽量避免使用）
  def cartesian() = {
    val rdd1 = sc.parallelize(1 to 5)
    val rdd2 = sc.parallelize(5 to 10)
    rdd1.cartesian(rdd2).foreach(print)
  }


  /**
    * 将两个RDD组合成Key/Value形式的RDD,这里默认两个RDD的partition数量以及元素数量都相同，否则会抛出异常。
    * 两个tuple长度不相同会造成数据丢失不会抛出去异常
    */
  def zipDemo() = {
    val rdd1 = sc.parallelize(Array(1, 2, 3), 3)
    val rdd2 = sc.parallelize(Array("a", "b", "c"), 3)
    rdd1.zip(rdd2).foreach(print)
  }
}
