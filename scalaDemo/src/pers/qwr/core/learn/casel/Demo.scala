package pers.qwr.core.learn.casel

object Demo {

  def main(args: Array[String]): Unit = {

    val dd = DD("你好")
    dd match {
      case d:DD => println(d.message)
      case _ => println("else ...")
    }

  }
}

case class DD(message: String)
