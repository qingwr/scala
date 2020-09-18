package pers.qwr.core.learn.genericity

object GenericTestTwo {
  def main(args: Array[String]): Unit = {
    val gt = new GenericTest2
    val huangbo = new Boy2("huangbo", 60)
    val xuzheng = new Boy2("xuzheng", 66)
    val boy = gt.choose(huangbo, xuzheng)
    println(boy)
  }
}


class GenericTest2 {
  //在方法上定义泛型
  def choose[T <: Comparable[T]](one: T, two: T): T = {
    if (one.compareTo(two) > 0) one else two
  }
}

class Boy2(val name: String, var age: Int) extends Comparable[Boy2] {
  override def compareTo(o: Boy2): Int = {
    this.age - o.age
  }
}