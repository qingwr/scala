package pers.qwr.core.learn.aggregate.demo

object ReduceDemo {

  def main(args: Array[String]): Unit = {
    demo1
    demo2
    demo3
  }

  def demo1() = {
    val list = List(1, 20, 30, 4, 5)
    println(list.reduceLeft((n, n2) => n + n2))
    println(list.reduce((n, n2) => n + n2))
  }

  def demo2() = {
    val list = List(1, 2, 3, 4, 5)

    def minus(n1: Int, n2: Int): Int = {
      n1 - n2
    }

    println(list.reduceLeft(minus))
    println(list.reduceRight(minus))
    println(list.reduce(minus))
  }

  def demo3() = {
    val list = List(3, 4, 2, 7, 5)
    println(list.reduce((n1, n2) => {
      if (n1 > n2) n2 else n1
    }))
  }
}
