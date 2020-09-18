package pers.qwr.core.learn.implicitl


/**
  * 丰富类库功能
  * 当本类有该属性时使用该类的属性, 否则使用转化类属性
  * 类似JS原型链
  **/
object Demo1 {

  val age = 18

  implicit def addDelete(mysql: MySQL): DB = {
    new DB //
  }

  def main(args: Array[String]): Unit = {
    val mysql = new MySQL
    println(mysql.getClass)
    println(mysql.age)
    mysql.insert
    mysql.delete
  }
}

class MySQL {
  val age = 20

  def insert(): Unit = {
    println("insert")
  }

  def delete(): Unit = {
    println("Mysql delete")
  }
}

class DB {
  val age = 19

  def delete(): Unit = {
    println("DB delete")
  }
}
