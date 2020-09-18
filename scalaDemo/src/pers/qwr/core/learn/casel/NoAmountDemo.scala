package pers.qwr.core.learn.casel

abstract class Amount

case class Dollar(value: Double) extends Amount

case class Currency(value: Double, unit: String) extends Amount

case object NoAmount extends Amount

object Amount2 {
  def main(args: Array[String]): Unit = {
    //    for (amt <- Array(Dollar(1000.0), Currency(1000.0, "RMB"), NoAmount)) {
    //      val result = amt match {
    //        case Dollar(v) => "$" + v
    //        case Currency(v, u) => v + " " + u
    //        case NoAmount => ""
    //      }
    //      println(amt + ": " + result)
    //    }
    //
    //    val amt = Currency(29.95, "RMB")
    //    var amt1 = amt.copy()
    //    var amt2 = amt.copy(value = 19.95)
    //    var amt3 = amt.copy(unit = "英镑")
    //    println(amt1)
    //    println(amt2)
    //    println(amt3)
    //
    //    var list = List(1, 3, 5, 9)
    //    list match {
    //      case first :: second :: rest => println(first + "**" + second + "**" + rest)
    //      case _ => println("匹配不到...")
    //    }

    //    println(List(1, 3, 5, "seven") map { case i: Int => i + 1 }) // won't work
    println(List(1, 3, 5, "seven") collect { case i: Int => i + 1 })
    println(assert(List(2, 4, 6) == (List(1, 3, 5, "seven") collect { case i: Int => i + 1 })))
  }
}