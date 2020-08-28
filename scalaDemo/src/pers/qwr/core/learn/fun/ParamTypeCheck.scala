package pers.qwr.core.learn.fun

object ParamTypeCheck {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)
    println(list.map(_ + 0))
    println(list.reduce(_ + _ + 2))
  }
}
