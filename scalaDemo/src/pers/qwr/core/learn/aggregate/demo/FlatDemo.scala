package pers.qwr.core.learn.aggregate.demo

object FlatDemo {
  def main(args: Array[String]) = {
    demo1()
  }

  def demo1() = {
    val names = List("Alice", "Bob", "Nick")
    println(names.flatMap(_.toUpperCase))
    println(names.map(_.toUpperCase))
  }
}
