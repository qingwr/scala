package pers.qwr.core.learn.implicitl

object ImplicitVal {

  def main(args: Array[String]): Unit = {
    hello
  }

  implicit val num = 222

  def hello(implicit name: String = "ssssss") = {
    println("Hello ", name)
  }
}
