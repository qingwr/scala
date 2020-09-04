package pers.qwr.spark.core.dynamic

object GenenricUse {

  def main(args: Array[String]): Unit = {
    val mes1 = new StrMessage[String]("100")
    println(mes1.get)
    val mes2 = new IntMessage[Int](20)
    println(mes2.get)
  }
}

abstract class Message[T](s: T) {
  def get: T = s
}

class StrMessage[String](msg: String) extends Message(msg)
class IntMessage[String](msg: Int) extends Message(msg)
