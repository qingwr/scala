package pers.qwr.core.learn.implicitl

object ValDemo {
  implicit val String = "jack"

  def hello(implicit name: String) = {
    println(name + " hello")
  }

  def main(args: Array[String]): Unit = {
    hello
    hello("CP3")
  }
}


