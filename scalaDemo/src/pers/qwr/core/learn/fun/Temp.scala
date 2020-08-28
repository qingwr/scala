package pers.qwr.core.learn.fun

object Temp {

  def main(args: Array[String]): Unit = {

    def test1(x: Double) = {
      (y: Double) => x * x * y
    }

    val res = test1(2)(3)
    println("res=" + res)

  }

}
