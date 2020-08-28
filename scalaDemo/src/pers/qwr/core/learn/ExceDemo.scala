package pers.qwr.core.learn

object ExceDemo {

  def main(args: Array[String]): Unit = {
    try {
      val r = 10 / 0
    } catch {
      case ex: ArithmeticException => println("捕获了除数为零的算术异常")
      case ex: Exception => println("捕获了异常")
    } finally {
      // 最终要执行的代码
      println("scala finally...")
    }

    try {
      f11()
    } catch {
      case ex: NumberFormatException => {
        println("捕获了NumberFormatException")
      }
    }

  }

  @throws(classOf[NumberFormatException])
  def f11() = {
    "abc".toInt
  }

}
