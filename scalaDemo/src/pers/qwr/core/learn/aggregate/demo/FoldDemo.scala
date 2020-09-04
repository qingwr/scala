package pers.qwr.core.learn.aggregate.demo

object FoldDemo {

  def main(args: Array[String]) = {
    demo1
  }

  def demo1(): Unit = {
    val list = List(1, 2, 3, 4)

    def minus(n1: Int, n2: Int): Int = {
      n1 - n2
    }

    println(list.foldLeft(5)(minus))
    println(list.foldRight(5)(minus))
  }

  def ab() = {
    val list4 = List(1, 9, 2, 8)

    def minus(n1: Int, n2: Int): Int = {
      n1 - n2
    }

    println((10 /: list4) (minus))
    println((list4 :\ 10) (minus))
  }

}
