plugins {
    scala
    application
}

dependencies {
    implementation "org.apache.spark:spark-sql_2.12:3.1.0"
    implementation("org.scala-lang:scala-library:2.13.4")

    testImplementation("org.scalatest:scalatest_2.13:3.2.3")
}
