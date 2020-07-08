package pers.qwr.spark.learn

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    wordCount(args(0), args(1), new SparkConf().setAppName("WC"))
  }

  def wordCount(input: String, output: String, conf: SparkConf): Unit = {
    var sc = new SparkContext(conf)
    sc.textFile(input).flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _, 1)
      .sortBy(_._2, false).saveAsTextFile(output)
    sc.stop()
  }
}
