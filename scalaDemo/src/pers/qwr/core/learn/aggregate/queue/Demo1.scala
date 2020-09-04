package pers.qwr.core.learn.aggregate.queue

import scala.collection.mutable

object Demo1 {
  def main(args: Array[String]): Unit = {
    //    create
    //    test
    change2
  }

  def create() {
    val q1 = new mutable.Queue[Int]
    q1 += 20
    println(q1)
    q1 ++= List(2, 4, 6)
    println(q1)
    //    q1 += List(1, 2, 3) 报错
  }

  def change() = {
    val q1 = new mutable.Queue[Int]
    q1 += 12
    q1 += 34
    q1 ++= List(2, 9)
    println(q1)
    q1.dequeue()
    q1.dequeue()
    println(q1)
    q1.enqueue(20, 60)
    println(q1)
  }

  def change2() = {
    val q1 = new mutable.Queue[Int]()
    q1 += 1
    q1 += 2
    q1 += 3
    q1 += 4
    println(q1.head)
    println(q1.last)
    // 除了第一个以外剩余的元素， 可以级联使用，这个在递归时使用较多。
    println(q1.tail)
  }

  def test(): Unit = {
    val cat = new Cat
    println(cat.age)
    cat += 9
    println(cat.age)
  }
}

class Cat {
  var age = 10

  def +=(n: Int) = {
    this.age += n
    println("xxx")
  }
}