package pers.qwr.core.learn.aggregate.array

object Demo1 {
  //  等同于Java中的数组,中括号的类型就是数组的类型
  def main(args: Array[String]): Unit = {
    create
    println
    create2
  }

  def create() = {
    val arr1 = new Array[Int](10)
    arr1(1) = 7
    for (a <- arr1) {
      print(a + "\t")
    }
  }

  def create2() = {
    val arr1 = Array(23, 23, 56, 62, 23, 23, 623, 4)
    arr1(1) = 7
    for (a <- arr1) {
      print(a + "\t")
    }
  }
}
