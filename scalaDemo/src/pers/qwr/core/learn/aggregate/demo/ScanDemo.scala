package pers.qwr.core.learn.aggregate.demo

object ScanDemo {

  def main(args: Array[String]) = {
    println((1 to 5).scanLeft(5)(minus))
    println((1 to 5).scanLeft(5)(add))
    println((1 to 3).scanLeft(3)(test))
  }

  def minus(n1: Int, n2: Int): Int = {
    n1 - n2
  }

  def add(n1: Int, n2: Int): Int = {
    n1 + n2
  }

  def test(i1: Int, i2: Int): Int = {
    i1 * i2
  }
}
