package pers.qwr.core.learn.fun

object ProcedureDemo {

  def main(args: Array[String]): Unit = {
    f10("请勿扰")

    def f1 = "ssss"
    println(f1.getClass)
  }

  //没有返回值的函数叫做过程
  def f10(name: String) = {
    println(name + "Hello")
  }
}

