package pers.qwr.core.learn.aggregate.demo

object FilterDemo {

  def main(args: Array[String]) = {
    demo1
  }

  def demo1() = {
    val names = List("Alice", "Bob", "Nick", 1)
    println(names.filter {
      case _:String => true
      case "Bob" => true
      case _ => false
    })
  }
}
