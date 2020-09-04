package pers.qwr.core.learn.aggregate.set

object Demo1 {
  def main(args: Array[String]): Unit = {
    create
    create2
    addDemo
    delDemo
    itDemo
  }

  def create() = {
    val set = Set(1, 2, 3) //不可变
    println(set)
  }

  def create2() = {
    import scala.collection.mutable.Set
    val set = Set(1, 2, 3) //可变
    println(set)
  }

  def addDemo() = {
    import scala.collection.mutable.Set
    val set = Set(1, 2, 3) //可变
    set.add(4)
    set += 1
    set += 2
    set += 2
    println(set)
  }

  def delDemo() = {
    import scala.collection.mutable.Set
    val set = Set(1, 2, 4, "Abc")
    set -= 2
    set.-=(4)
    set.remove("abc")
    println(set)
  }

  def itDemo() = {
    import scala.collection.mutable.Set
    val set = Set(1, 2, 4, "Abc")
    set.foreach(println)
    for (x <- set) {
      print(x + "\t")
    }
  }
}
