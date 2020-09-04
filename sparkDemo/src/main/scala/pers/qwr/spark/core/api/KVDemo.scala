package pers.qwr.spark.core.api

/**
  * * rdd key-value常用算子练习实例
  **/

import pers.qwr.spark.core.sc

object KVDemo {

  def main(args: Array[String]): Unit = {
    //    partitionByDemo
    //    groupByKeyDemo
    //    reduceByKeyDemo
    //    aggregateByKeyDemo
    //    foldByKeyDemo
    //    combineByKyeDemo
    //    sortByKeyDemo
    //    mapValuesDemo
    //    joinDemo
    cogroupDemo
    sc.stop
  }

  /**
    * 作用：对pairRDD进行分区操作，如果原有的partionRDD和现有的partionRDD是一致的话就不进行分区，
    * 否则会生成ShuffleRDD，即会产生shuffle过程。
    **/
  def partitionByDemo() = {
    val rdd = sc.parallelize(Array((1, "aaa"), (2, "bbb"), (3, "ccc"), (4, "ddd")), 4)
    val pRdd = rdd.partitionBy(new org.apache.spark.HashPartitioner(2))
    //    val crdd = rdd.coalesce(4)
    println(pRdd.partitions.size)
  }

  /**
    * 作用：groupByKey也是对每个key进行操作，但只生成一个sequence。
    * wordCount demo
    **/
  def groupByKeyDemo() = {
    val words = Array("one", "two", "two", "three", "three", "three")
    sc.makeRDD(words).map((_, 1)).groupByKey().map(res => (res._1, res._2.size)).foreach(print)
  }

  /**
    * 返回一个(K,V)的RDD，使用指定的reduce函数，将相同key的值聚合到一起，reduce任务的个数可以通过第二个可选的参数来设置。
    * shuffle之前有combine（预聚合）操作 要比groupByKey效率高
    **/
  def reduceByKeyDemo() = {
    val rdd = sc.parallelize(List(("female", 1), ("male", 5), ("female", 5), ("male", 2)))
    rdd.reduceByKey((x, y) => x + y).foreach(println)
  }


  /**
    * param1 初始值,给每一个分区中的每一个key一个初始值
    * param2 函数用于在每一个分区中用初始值逐步迭代value;分区内操作_ + _ 第一个_表示初始值, 第二个_表示rdd元素的value
    * param3 函数用于合并每个分区中的结果; _ + _ 表示 不同分区的value
    **/
  def aggregateByKeyDemo() = {
    val rdd = sc.parallelize(Array(("a", 3), ("a", 2), ("c", 4), ("b", 3), ("c", 6), ("c", 8)), 2)
    val agg = rdd.aggregateByKey(0)(_ + _, _ + _).foreach(println)

  }

  /**
    * aggregateByKey的简化操作，seqop和combop相同
    **/
  def foldByKeyDemo() = {
    val rdd = sc.parallelize(List((1, 3), (1, 2), (1, 4), (2, 3), (3, 6), (3, 8)), 3)
    rdd.foldByKey(0)(_ + _).foreach(println)
  }


  /**
    * 1.对相同K，把V合并成一个集合。
    * param fun1:多个key绑定其中一个key
    * param fun2: v会自动累加
    * param fun3: 分区合并
    **/
  def combineByKyeDemo() = {
    val input = sc.parallelize(Array(("a", 88), ("b", 95), ("a", 91), ("b", 93), ("a", 95), ("b", 98)))
    val combine = input.combineByKey((_, 1), (acc: (Int, Int), v) => (acc._1 + v, 0), (acc1: (Int, Int), acc2: (Int, Int)) => (acc1._1 + acc2._1, acc1._2 + acc2._2))
    combine.foreach(println)
  }

  /**
    * 按key排序
    * spark模式下for是并发执行的, 所以这里输出还是会乱序
    **/
  def sortByKeyDemo() = {
    val rdd = sc.parallelize(Array((3, "aa"), (6, "cc"), (2, "bb"), (1, "dd")))
    rdd.sortByKey().foreach(println)
  }

  /**
    * 针对于(K,V)形式的类型只对V进行操作
    **/
  def mapValuesDemo() = {
    val rdd3 = sc.parallelize(Array((1, "a"), (1, "d"), (2, "b"), (3, "c")))
    rdd3.mapValues(_.size + 3).foreach(println)
  }

  /**
    * 在类型为(K,V)和(K,W)的RDD上调用，返回一个相同key对应的所有元素对在一起的(K,(V,W))的RDD
    * 同一个pariRDD相同的KEY不会聚合
    * 两个rdd的key唯一时不会聚合
    **/
  def joinDemo() = {
    val rdd = sc.parallelize(Array((1, "a"), (2, "b"), (3, "c")))
    val rdd1 = sc.parallelize(Array((1, 4), (2, 5), (3, 6)))
    rdd.join(rdd1).foreach(println)
  }

  /**
    * 作用：在类型为(K,V)和(K,W)的RDD上调用，返回一个(K,(Iterable<V>,Iterable<W>))类型的RDD
    **/
  def cogroupDemo() = {
    val rdd = sc.parallelize(Array((1, "a"), (2, "b"), (3, "c")))
    val rdd1 = sc.parallelize(Array((1, 4), (2, 5)))
    rdd.cogroup(rdd1).foreach(println)
  }

}
