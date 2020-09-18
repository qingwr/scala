package pers.qwr.core.learn.implicitl

object ClassDemo {
  def main(args: Array[String]): Unit = {
    implicit class DB1(val m: Mysql1) {
      def addSuffix(): String = {
        " Scala"
      }
    }
    val mysql1 = new Mysql1
    mysql1.sayOK
    println(mysql1.addSuffix)
    mysql1.hello
  }

}

trait Test {
  def hello(): Unit = {
    println("Test hello")
  }
}

trait Test2 {
  def hello2(): Unit = {
    println("Test2 hello")
  }
}

class Mysql1 extends Test with Test2 {
  def sayOK() = {
    println("sayOK")
  }

  override def hello(): Unit = {
    super.hello
    println("Mysql de Hleoo")
  }
}
