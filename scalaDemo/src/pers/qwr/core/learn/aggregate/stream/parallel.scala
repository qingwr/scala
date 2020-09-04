package pers.qwr.core.learn.aggregate.stream

object parallel {

  //  .par 把任务分割cpu核数执行
  def main(args: Array[String]): Unit = {
    val result1 = (0 to 100).map { _ => Thread.currentThread.getName }
    val result2 = (0 to 100).par.map { _ => Thread.currentThread.getName }
    println(result1)
    println(result2)
    println(result2.map((_, 1)).groupBy(_._1).map(i => (i._1, i._2.size)))
  }
}
