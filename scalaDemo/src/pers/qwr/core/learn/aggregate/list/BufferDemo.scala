package pers.qwr.core.learn.aggregate.list

import scala.collection.mutable.ListBuffer

object BufferDemo {

  def main(args: Array[String]): Unit = {
    demo1()
  }

  def demo1() = {
    val lst0 = ListBuffer(1, 2, 3)
    val lst1 = ListBuffer(1, 2, "三")
    lst1 ++= lst0
    lst1.appendAll(lst0)
    println(lst1)


  }

}
