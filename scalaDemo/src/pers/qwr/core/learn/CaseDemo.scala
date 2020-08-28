package pers.qwr.core.learn

import util.control.Breaks._

object CaseDemo {

  def main(args: Array[String]): Unit = {
    for (i <- 1 to 2) {
      print(i + " ")
    }
    //    1 2
    println()

    for (i <- 1 until 2) {
      print(i + " ")
    }
    //    1
    println()

    for (i <- 1 to 3 if i != 2) {
      print(i + " ")
    }
    println()
    //    1 3

    for (i <- 1 to 3; j = 4 - i) {
      print(j + " ")
    }
    //    3 2 1
    println()

    for (i <- 1 to 9; j <- 1 to 9) {
      println(i + " * " + j + " = " + (i * j))
    }
    //    九九乘法表
    println()

    //    返回Vector
    val res = for (i <- 1 to 10) yield i * 2
    println(res)

    var n = 10
    breakable {
      while (n <= 20) {
        n += 1
        if (n == 18) {
          break()
        }
      }
    }
    println("n=" + n)

  }
}
