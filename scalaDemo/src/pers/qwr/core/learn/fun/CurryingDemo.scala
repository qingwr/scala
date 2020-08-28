package pers.qwr.core.learn.fun

object CurryingDemo {

  def main(args: Array[String]): Unit = {
    println(addMulti(50, 80, 20))
    println(addMultiCurry(50)(80)(20))
    println(eq2("11111")("sss"))
  }

  def addMulti(a: Int, b: Int, c: Int) = (a + b) * c

  def addMultiCurry(a: Int) = {
    (b: Int) => (c: Int) => (a + b) * c
  }

  def eq2(s1: String)(s2: String): Boolean = {
    s1.toLowerCase == s2.toLowerCase
  }

}

