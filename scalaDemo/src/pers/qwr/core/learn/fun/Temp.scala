package pers.qwr.core.learn.fun

object Temp {

  def main(args: Array[String]): Unit = {
    for (list <- Array(List(0), List(1, 0), List(0, 0, 0), List(1, 0, 0))) {
      val result = list match {
        case 0 :: Nil => "0" //
        case x :: y :: Nil => x + " " + y
        case 0 :: tail => "0 ..." + tail
        case _ => "something else"
      }
      println(result)
    }

  }

  def demo(): Unit ={
    val obj = 10
    val result = obj match {
      case a : Int => a
      case _ => "啥也不是"
    }

  }

  def filterCase(): Unit = {
    val list = List(1, 2, 3, 4, "abc")
    list.filter(x =>
      x match {
        case t: Int => println(1); true
        case _ => println(2); false
      }
    ).foreach(println)
  }

}
