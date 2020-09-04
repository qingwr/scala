package pers.qwr.core.learn.aggregate.demo

import scala.collection.mutable.ListBuffer

object Demo1 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 5, 3)
    listX2(list)
    listX2_1(list)
    println
    listX2_2(list)
    toUpperCaseDemo
  }

  def listX2(list: List[Int]) = {
    val lb = ListBuffer[Int]()
    for (l <- list) {
      lb.append(l * 2)
    }
    val result = lb.toList
    println(result)
  }

  def listX2_1(lst: List[Int]) = {
    lst.map(_ * 2).foreach(x => print(x + "\t"))
  }

  def listX2_2(lst: List[Int]) = {
    def f1(n1: Int): Int = {
      n1 * 2
    }

    println(lst.map(f1))
  }

  def toUpperCaseDemo() = {
    val names = List("Alice", "Bob", "Nick")
    val newNames = for (name <- names) yield name.toUpperCase
    println(newNames)
  }
}
