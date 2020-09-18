package pers.qwr.core.learn.casel

object Square {
  def unapply(z: Double): Option[Double] = Some(math.sqrt(z))

  def apply(z: Double): Double = z * z

  def main(args: Array[String]): Unit = {
    val number: Double = 36.0
    number match {
      case Square(n) => println(n + "..")
      case _ => println("nothing matched")
    }
    println(Square(3.3d))


  }
}
