

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Demo2 {

  def main(args: Array[String]): Unit = {
    //    demo3
    //    mapDemo
    //    test
    wordCount
  }

  def test() = {
    val map4 = mutable.Map[String, Int](("A", 1), ("B", 11), ("C", 3))
    map4 + ("E" -> 1, "F" -> 3)

  }

  def charCount(): Map[Char, Int] = {
    var map = Map[Char, Int]('a' -> 1)
    var a = '1'
    map + (a -> 1)
  }

  def putArry(arr: ArrayBuffer[Char], c: Char): ArrayBuffer[Char] = {
    arr.append(c)
    arr
  }

  def mapDemo(): Unit = {
    val sentence = "AAAAAAAAAABBBBBBBBCCCCCDD"

    def charCount(map: Map[Char, Int], c: Char): Map[Char, Int] = {
      map + (c -> (map.getOrElse(c, 0) + 1))
    }

    val map2 = sentence.foldLeft(Map[Char, Int]())(charCount)
    println(map2)

  }

  def wordCount() = {
    val lines = List("atguigu liu hello ddd", "atguigu liu aaa aaa aaa ccc ddd uuu", "liu", "ddd")
    println(lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).map(m => (m._1, m._2.size)).toList.sortBy(_._2).reverse)
  }

}
