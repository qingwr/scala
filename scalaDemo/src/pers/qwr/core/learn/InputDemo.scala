package pers.qwr.core.learn

import scala.io.StdIn

object InputDemo {

  /*
  * printf 格式化输出
  %d 十进制数字
  %s 字符串
  %c 字符
  %e 指数浮点数
  %f 浮点数
  %i 整数（十进制）
  %o 八进制
  %u 无符号十进制
  %x 十六进制
  %% 打印%
  % 打印%
  * */

  def main(args: Array[String]): Unit = {
    print("name: ")
    var name = StdIn.readLine()
    print("age: ")
    var age = StdIn.readInt()
    print("sal: ")
    var sal = StdIn.readDouble()
    printf(s"name: %s , age: %d, sal: %f", name, age, sal)
  }
}
