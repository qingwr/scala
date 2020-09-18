package pers.qwr.core.learn.genericity

object Card {
  def getIDCard[T >: Son](person: T): Unit = {
    println(person.getClass + "! OK,交给你了")
  }

  def main(args: Array[String]): Unit = {
    getIDCard[GranderFather](new Father)
    getIDCard[GranderFather](new GranderFather)
    getIDCard[GranderFather](new Son)
    //getIDCard[GranderFather](new Tongxue)//报错，所以注释
  }

}

class GranderFather

class Father extends GranderFather

class Son extends Father

class Tongxue
