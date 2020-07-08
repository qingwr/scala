package pers.qwr.spark.learn

import org.apache.spark.SparkConf

object WordCountTest extends App {

  WordCount.wordCount("input", "ouput", new SparkConf().setAppName("WC").setMaster("local[*]"));

}
