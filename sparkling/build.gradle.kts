plugins {
    scala
    application
}
repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

dependencies {
    val sparkVersion = "3.1.0"
    implementation("org.apache.spark:spark-core_2.12:$sparkVersion")
    implementation("org.apache.spark:spark-sql_2.12:$sparkVersion")
    implementation("org.scala-lang:scala-library:2.12.11")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    testImplementation("org.apache.spark:spark-sql_2.12:$sparkVersion:tests")
    testImplementation("org.apache.spark:spark-core_2.12:$sparkVersion:tests")
    testImplementation("org.apache.spark:spark-catalyst_2.12:$sparkVersion:tests")
    testImplementation("org.scalatest:scalatest_2.12:3.2.3")
}
