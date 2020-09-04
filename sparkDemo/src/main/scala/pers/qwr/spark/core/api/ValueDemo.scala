package pers.qwr.spark.core.api

/**
  * rdd 单value常用算子练习实例
  **/

import pers.qwr.spark.core.sc

object ValueDemo {

  def main(args: Array[String]): Unit = {
    //    mapDemo
    //    mapPartitionsDemo
    //    mapPartitionsWithIndexDemo
    //    flatMapDemo
    //    flatMapDemo2
    //    glomDemo
    //    groupByDemo
    //    sampleDemo
    //    distinctDemo
    //    coalesceDemo
    //    repartitionDemo
    //    sortByDemo
    sc.stop
  }

  /**
    * f: v => c
    * v 与 c 一对一
    * v :集合的值
    * c :目标类型
    **/
  def mapDemo() = {
    var arr = List("CP3", "MJ", "KG", "CP3", "CP3", "PP")
    arr.map((_, 1)).foreach(println)
    arr.map(_ + " is good!").foreach(println)
    sc.stop()
  }

  /**
    * map和mapPartition 区别
    * 1. map()：每次处理一条数据。
    *2. mapPartition()：每次处理一个分区的数据，这个分区的数据处理完后，原RDD中分区的数据才能释放，可能导致OOM。
    *3. 开发指导：当内存空间较大的时候建议使用mapPartition()，以提高处理效率。
    **/
  def mapPartitionsDemo() = {
    val rdd = sc.parallelize(Array(1, 2, 3, 4))
    rdd.mapPartitions(i => i.map(_ + 1)).foreach(println)
  }

  /**
    * 类似于 mapPartition
    * f: partition, intertor[v] => intertor[c]
    **/
  def mapPartitionsWithIndexDemo() = {
    val rdd = sc.parallelize(Array(1, 2, 3, 4), 2)
    val indexRdd = rdd.mapPartitionsWithIndex((index, items) => items.map((index, _)))
    indexRdd.foreach(println)
  }

  /**
    * 类似于map，但是每一个输入元素可以被映射为0或多个输出元素（所以func应该返回一个序列，而不是单一元素）
    * f: v => n1 n2... n+
    **/
  def flatMapDemo() = {
    val sourceFlat = sc.parallelize(1 to 5)
    sourceFlat.flatMap(1 to _).foreach(println)
    //    var name = "qingwangrong"
    //    name.toCharArray.flatMap(_ + ", ").foreach(print(_))
  }

  def glomDemo() = {
    val result = sc.makeRDD(1 to 16, 4).glom().collect
  }

  def groupByDemo(): Unit = {
    val rdd = sc.parallelize(1 to 4)
    rdd.groupBy(_ % 2).foreach(println(_))
  }

  /**
    * 随机抽样
    * 第一个参数为True会出现重复的数，第二个参数表示随机数的比例，第三个参数表示随机的种子
    **/

  def sampleDemo() = {
    val add = sc.makeRDD(1 to 10)
    val sampleTrue = add.sample(true, 0.2, 10)
    val sampleFalse = add.sample(false, 0.2, 10)
    sampleTrue.collect.foreach(x => print(x + "\t"))
    sampleFalse.collect.foreach(x => print(x + "\t"))
  }

  /**
    * 去重
    * 默认8并行
    **/
  def distinctDemo() = {
    val distinctRdd = sc.parallelize(List(1, 2, 1, 5, 2, 9, 6, 1))
    distinctRdd.distinct().foreach(n => print(n + "\t"))
  }

  /**
    * 缩减分区数，用于大数据集过滤后，提高小数据集的执行效率。
    * ！！！不能扩大
    **/
  def coalesceDemo() = {
    val rdd = sc.parallelize(1 to 16, 4)
    println(rdd.partitions.size)
    val crdd = rdd.coalesce(2)
    println(crdd.partitions.size)
  }

  /**
    * 1. coalesce重新分区，可以选择是否进行shuffle过程。由参数shuffle: Boolean = false/true决定。
    *2. repartition实际上是调用的coalesce，默认是进行shuffle的。源码如下：
    */
  def repartitionDemo() = {
    val rdd = sc.parallelize(1 to 16, 4)
    println(rdd.partitions.size)
    val crdd = rdd.repartition(2)
    println(crdd.partitions.size)
  }

  /**
    * 排序
    * true到
    */
  def sortByDemo() = {
    val rdd = sc.makeRDD(List(2, 1, 3, 4))
    //    rdd.sortBy(x => x, true).foreach(n => print(n + "\t"))
    rdd.sortBy(x => x, false).foreach(n => print(n + "\t"))
  }

  /**
    * 作用：管道，针对每个分区，都执行一个shell脚本，返回输出的RDD。
    */
  def pipDemo() {
    val rdd = sc.parallelize(List("hi", "Hello", "how", "are", "you"), 1)
    rdd.pipe("/opt/module/spark/pipe.sh").collect()
    /*
    #!/bin/sh
      echo "AA"
    while read LINE; do
      echo ">>>"${LINE}
    done
    */
  }

}
