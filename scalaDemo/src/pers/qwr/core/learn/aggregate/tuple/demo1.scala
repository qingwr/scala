package pers.qwr.core.learn.aggregate.tuple

object Demo1 {
  //  元组中最大只能有22个元素
  def main(args: Array[String]): Unit = {
    createTuple
    createTuple2
    iteratorDemo
    getElement()
  }

  def createTuple() = {
    val tu = (2, 12, 134, 34, 43, 23, 23, 23d)
    println(tu)
  }

  def createTuple2() = {
    var tup1 = 2 -> "two"
    var tup2 = 0 -> "zero"
    var tup3 = 5 -> "five"
    var tup4 = 6 -> 5 -> "six"
    println(tup1)
    println(tup4)
  }

  def iteratorDemo() = {
    val t1 = (1, "a", "b", true, 2)
    for (item <- t1.productIterator) {
      println(item)
    }
  }

  def getElement() = {
    val t1 = (1, "a", "b", true, 2)
    println(t1._1)
    println(t1.productElement(3))
  }

}
