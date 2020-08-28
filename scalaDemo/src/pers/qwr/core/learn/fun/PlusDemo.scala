package pers.qwr.core.learn.fun

object PlusDemo {

  def main(args: Array[String]): Unit = {
    println(apply(fmtInt,1200))
    println(addBy(50)(555.55))
  }

  def apply(f: Int => String, v: Int) = f(v)

  def fmtInt(n:Int):String = "[整数值{" + n + "}]"

  def addBy(n: Int) = {
    (d : Double) => n + d
  }
}
