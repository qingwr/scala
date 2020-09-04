package pers.qwr.core.learn.aggregate.map

import scala.collection.mutable

object Demo1 {

  //  不可变的Map是有序的(默认)，可变的Map是无序的
  def main(args: Array[String]): Unit = {
    create
    println("---------------")
    create2
    println("---------------")
    create3
    println("---------------")
    create4
    println("---------------")
    getDemo
    println("---------------")
    change
    println("---------------")
    itDemo
  }

  def create() = {
    val map1 = Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> "北京")
    map1.foreach(println)
  }

  def create2() = {
    val map2 = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> 30)
    map2.foreach(println)
  }

  def create3(): Unit = {
    val map3 = new scala.collection.mutable.HashMap[String, Int]
    println(map3)
  }

  def create4() = {
    //    包含键值对的二元组， 和第一种方式等价，只是形式上不同而已。
    //    对偶元组 就是只含有两个数据的元组
    val map4 = Map(("A", 1), ("B", 2), ("C", 3), ("D", 30))
    println("map4=" + map4)
    println(map4("A"))
  }

  /**
    * 1) 如果键存在, 返回对应的值对象
    * 2) 如果键不存在, 抛出异常
    * 3) 在java中 如果不存在返回null
    * 使用containts先判断在取值，可以防止异常，并加入相应的处理逻辑
    * 映射.get(键) 这样的调用返回一个Option对象，要么是Some，要么是None
    */
  def getDemo() = {
    val map1 = Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> "北京")
    println(map1.get("Alice"))
    println(map1.get("Alice").get)
  }

  def change() = {
    val map4 = mutable.Map(("A", 1), ("B", "北京"), ("C", 3))
    map4 -= ("A", "B")
    println("map4=" + map4)
  }

  def itDemo() = {
    val map1 = mutable.Map(("A", 1), ("B", "北京"), ("C", 3))
    for ((k, v) <- map1) println(k + " is mapped to " + v)
    for (v <- map1.keys) println(v)
    for (v <- map1.values) println(v)
    for (v <- map1) println(v)


  }
}
