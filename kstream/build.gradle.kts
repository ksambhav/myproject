plugins {
    scala
    kotlin("jvm")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {

    implementation("com.github.javafaker:javafaker:1.0.2")

    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("ch.qos.logback:logback-classic:1.2.3")

    implementation("org.apache.logging.log4j:log4j-api:2.14.0")
    implementation("org.apache.logging.log4j:log4j-core:2.14.0")


    implementation("org.apache.kafka:kafka-streams:2.7.0")
    implementation("org.apache.kafka:kafka-clients:2.7.0")

    implementation("org.scala-lang:scala-library:2.13.4")
    testImplementation("org.scalatest:scalatest_2.13:3.2.3")
    compileOnly("org.projectlombok:lombok:1.18.16")
    annotationProcessor("org.projectlombok:lombok:1.18.16")
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

}
tasks.getByName<Jar>("jar") {
    enabled = true
}