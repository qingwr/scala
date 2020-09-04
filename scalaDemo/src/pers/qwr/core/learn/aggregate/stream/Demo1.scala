package pers.qwr.core.learn.aggregate.stream

object Demo1 {

  def main(args: Array[String]): Unit = {
    println(numsForm(5).map(x => x * x))

  }

  def numsForm(n: BigInt): Stream[BigInt] = n #:: numsForm(n + 1)

  val stream1 = numsForm(1)
}
