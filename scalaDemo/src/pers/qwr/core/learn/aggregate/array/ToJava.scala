package pers.qwr.core.learn.aggregate.array

import scala.collection.mutable.ArrayBuffer

object ToJava {
  def main(args: Array[String]): Unit = {
    arrToJava
    arrJavaToScala
  }

  def arrToJava() = {
    val arr = ArrayBuffer("1", "2", "3")
    import scala.collection.JavaConversions.bufferAsJavaList
    val javaArr = new ProcessBuilder(arr)
    val arrList = javaArr.command()
    println(arrList)
  }

  def arrJavaToScala() = {
    import scala.collection.JavaConversions.bufferAsJavaList
    val javaArr = new ProcessBuilder(ArrayBuffer("1", "2", "3"))
    val arrList = javaArr.command()

    import scala.collection.JavaConversions.asScalaBuffer
    import scala.collection.mutable
    // java.util.List ==> Buffer
    val scalaArr: mutable.Buffer[String] = arrList
    scalaArr.append("jack")
    println(scalaArr)

  }
}
