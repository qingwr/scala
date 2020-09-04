package pers.qwr.core.learn.aggregate.join

object Demo1 {

  def main(args: Array[String]): Unit = {
    zipDemo
    iteratorDemo
  }

  def zipDemo() = {
    val list1 = List(1, 2, 3)
    val list2 = List(4, 5, 6)
    val list3 = list1.zip(list2)
    println("list3=" + list3)
  }

  def iteratorDemo()={
    val list = List[Int](1,2,5,3,6).iterator
    while(list.hasNext){
      print(list.next() + "\t")
    }
    println
  }

}
