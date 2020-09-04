package pers.qwr.core.learn.aggregate.stream

object ViewDemo {

  //集合惰性
  def main(args: Array[String]): Unit = {
    //说明: 没有使用view
    val viewSquares1 = (1 to 100).filter(eq)
    //    println(viewSquares1)

    //使用view
    val viewSquares2 = (1 to 100).view.filter(eq)
    println(viewSquares2)

  }

  def eq(i: Int): Boolean = {

    var a = i.toString.equals(i.toString.reverse)
    if (a) {
      println(i.toString + "\t" + i.toString.reverse)
    }
    a

  }

}
