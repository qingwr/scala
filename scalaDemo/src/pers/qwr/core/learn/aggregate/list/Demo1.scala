package pers.qwr.core.learn.aggregate.list

/**
  * List 在 scala包对象声明的,因此不需要引入其它包也可以使用
  * val List = scala.collection.immutable.List
  * List 中可以放任何数据类型，比如 arr1的类型为 List[Any]
  * 如果希望得到一个空列表，可以使用Nil对象, 在 scala包对象声明的,因此不需要引入其它包也可以使用
  **/
object Demo1 {

  def main(args: Array[String]): Unit = {
    create
    //    core()
    //    change()
    //    change2()
    append()
  }

  def create() = {
    val list01 = List(1, 2, 3) //创建时，直接分配元素
    println(list01)
    val list02 = Nil //空集合
    println(list02)
  }

  def core() = {
    val list1 = List(2, 3, 5, 1, 6, 3, 1, "1123", true)
    val value1 = list1(1) // 1是索引，表示取出第2个元素.
    println(value1)
  }

  def change() = {
    var list1 = List(1, 2, 3, "abc")
    // :+运算符表示在列表的最后增加数据

    val list2 = list1 :+ 1
    println(list1) //list1没有变化
    println(list2) //新的列表结果是 [1, 2, 3, "abc", 4]

    var list01 = List(1, 2, 3, "abc")
    // :+运算符表示在列表的最后增加数据
    val list3 = 4 +: list01
    println(list01) //list01没有变化
    println(list3) //新的列表结果是?
  }

  def change2() = {
    val list1 = List(1, 2, 3, "abc")
    val list5 = 4 :: 5 :: 6 :: list1 :: Nil // 从右向左的逻辑
    println(list5)
    val list7 = 4 :: 5 :: 6 :: list1 ::: Nil
    println(list7)
  }

  def append() = {

    val list1 = List(1, 2, 3, "abc")
    val list5 = 4 :: 5 :: 6 :: list1
    println(list5)

    val list6 = 4 :: 5 :: 6 :: list1 ::: Nil
    println(list6)

    //    val list7 = 4 :: 5 :: 6 :: list1 :: 9 报错
    val list7 = 4 :: 5 :: 6 :: list1 :: Nil
  }
}
