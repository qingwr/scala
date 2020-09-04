package pers.qwr.spark.core.api

/**
  * 创建RDD练习实例
  **/

import pers.qwr.spark.core.sc

object CreateRddDemo {
  
  def main(args: Array[String]): Unit = {
    var arrSource = sc.parallelize(1 to 10)
    println(arrSource.getClass)

    var input = sc.textFile("input")
    println(input.getClass)

    var toRdd = arrSource.map(_ + "")
    println(toRdd.getClass)
  }
}
