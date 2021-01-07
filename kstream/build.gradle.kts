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
    implementation("org.scala-lang:scala-library:2.11.12")
    testImplementation("org.scalatest:scalatest_2.11:3.0.0")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

}
tasks.getByName<Jar>("jar") {
    enabled = true
}