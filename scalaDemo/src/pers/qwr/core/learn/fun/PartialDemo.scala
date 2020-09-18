package pers.qwr.core.learn.fun

object PartialDemo {

  def main(args: Array[String]): Unit = {
    val inc = new PartialFunction[Any, Int] {
      def apply(any: Any) = any.asInstanceOf[Int] + 1

      def isDefinedAt(any: Any) = if (any.isInstanceOf[Int]) true else true
    }

    println(List(1, 3, 5, "seven") collect inc)

  }
}
