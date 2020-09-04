package pers.qwr.core.learn.aggregate.array

import scala.collection.mutable.ArrayBuffer

/**
  * ArrayBuffer是变长数组，类似java的ArrayList
  * val arr2 = ArrayBuffer[Int]() 也是使用的apply方法构建对象
  * def append(elems: A*) { appendAll(elems) } 接收的是可变参数.
  * 每append一次，arr在底层会重新分配空间，进行扩容，arr2的内存地址会发生变化，也就成为新的ArrayBuffer
  **/

object BufferDemo {

  def main(args: Array[String]): Unit = {
    create
    dimDemo()
  }

  def cast() = {
    val arr2 = ArrayBuffer[Int]()
    var arr1 = Array(1, 1, 1, 1)
    arr1.toBuffer //定长数组转可变数组
    arr2.toArray //可变数组转定长数组
  }

  def create() = {
    val arr2 = ArrayBuffer[Int]()
    //  追加
    arr2.append(7)
    // 重置
    arr2(0) = 17
    arr2.foreach(n => println(n + "\t"))
  }

  def dimDemo() = {
    val arr = Array.ofDim[Double](3, 4)
    arr.foreach(items => {
      items.foreach(i => print(i + "\t"))
      println
    })
  }

}
