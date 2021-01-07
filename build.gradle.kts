import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    id("java-library") // or id("application")
    id("application")
    id("org.springframework.boot") version "2.4.1" apply false
    id("io.spring.dependency-management") version "1.0.10.RELEASE" apply false

    kotlin("jvm") version "1.4.10" apply false
    kotlin("plugin.spring") version "1.4.10" apply false
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

allprojects {
    group = "com.samsoft"
    version = "1.0.0"

    tasks.withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }


    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
            incremental = true
        }
    }
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin("io.spring.dependency-management")
    }

}
