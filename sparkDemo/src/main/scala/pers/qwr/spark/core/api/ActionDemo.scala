package pers.qwr.spark.core.api

import pers.qwr.spark.core.sc

/**
  * Action练习实例
  **/

object ActionDemo {
  def main(args: Array[String]): Unit = {
    //    reduceDemo
    //    collectDemo
    //    countDemo
    //    firstDemo
    //    takeDemo
    //    takeOrderredDemo
    //    topDemo
    //    aggregateDemo
    //    foldDemo
    //    saveAsTextFileDemo
    //    saveAsObjectFileDemo
    countByKeyDemo

    if (!sc.isStopped) {
      sc.stop()
    }
  }

  /**
    * 创建一个RDD，将所有元素聚合得到结果。
    **/
  def reduceDemo() = {
    val rdd1 = sc.makeRDD(1 to 10, 2)
    println(rdd1.reduce(_ + _))
  }

  /**
    * 在驱动程序中，以数组的形式返回数据集的所有元素。
    * 生产中慎用
    **/
  def collectDemo() = {
    val rdd = sc.parallelize(1 to 10)
    rdd.collect
  }

  /**
    * 返回RDD中元素的个数
    **/
  def countDemo() = {
    val rdd = sc.parallelize(1 to 10)
    println(rdd.count)
  }

  /**
    * 返回RDD中的第一个元素
    **/
  def firstDemo() = {
    val rdd = sc.parallelize(1 to 10)
    println(rdd.first)
  }

  /**
    * 返回一个由RDD的前n个元素组成的数组
    **/
  def takeDemo() = {
    val rdd = sc.parallelize(Array(2, 5, 4, 6, 8, 3))
    rdd.take(3).foreach(println)
  }

  /**
    * 返回该RDD排序后的前n个元素组成的数组
    * 小到大
    **/
  def takeOrderredDemo() = {
    val rdd = sc.parallelize(Array(2, 5, 4, 6, 8, 3))
    // 隐式变量
    // implicit val myOrd = implicitly[Ordering[Int]].reverse
    rdd.takeOrdered(3).foreach(print(_))
  }

  /**
    * 类似takeOrderredDemo, 排序
    * 从大到小
    **/
  def topDemo(): Unit = {
    val rdd = sc.parallelize(Array(2, 5, 4, 6, 8, 3))
    //    implicit val myOrd = implicitly[Ordering[Int]].reverse
    rdd.top(3).foreach(print(_))
  }

  /**
    * 1.每个分区设置一个初始值
    * 2.分区聚合
    * 2.合并分区
    **/
  def aggregateDemo() = {
    val rdd = sc.parallelize((1 to 10), 2)
    //    println(rdd.aggregate(0)((x, y) => x + y, (x, y) => x + y))
    println(rdd.aggregate(0)(_ + _, _ + _))
  }

  /**
    * aggregate的简化操作，seqop和combop一样
    **/
  def foldDemo() = {
    val rdd = sc.parallelize((1 to 10), 2)
    println(rdd.fold(0)(_ + _))
  }

  /**
    * 将数据集的元素以textfile的形式保存到HDFS文件系统或者其他支持的文件系统，
    **/
  def saveAsTextFileDemo() = {
    val rdd = sc.parallelize((1 to 10), 2)
    //    rdd.saveAsTextFile("hdfs://node1:9000/spark/test")
    rdd.saveAsTextFile("D://dir")

  }

  /**
    * RDD中的元素序列化成对象，存储到文件中。
    **/
  def saveAsObjectFileDemo() = {
    val rdd = sc.parallelize((1 to 10), 2)
    rdd.saveAsObjectFile("test")
  }

  def countByKeyDemo() = {
    val rdd = sc.parallelize(List((1, 3), (1, 2), (1, 4), (2, 3), (3, 6), (3, 8)), 3)
    rdd.countByKey.foreach(println)
  }
}
