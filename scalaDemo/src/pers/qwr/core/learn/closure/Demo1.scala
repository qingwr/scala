package pers.qwr.core.learn.closure

object Demo1 {

  def main(args: Array[String]): Unit = {


  }

  def myRunInThread(f1: () => Unit) = {
    new Thread {
      override def run(): Unit = {
        f1()
      }
    }.start()
  }


}
