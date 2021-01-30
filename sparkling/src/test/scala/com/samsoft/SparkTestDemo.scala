package com.samsoft

import org.apache.spark.sql.test.SharedSparkSession


class SparkTestDemo extends SharedSparkSession {

  test("test") {
    println("test")
  }

}
