//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
// чтобы запускать необходимо подтянуть в InellJ плагин Spek
plugins {
    kotlin("jvm") version "1.8.21"
    id("io.qameta.allure") version "2.8.1"
    jacoco
    application
}

group = "ru.sindm"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:2.0.19")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:2.0.19")
    testImplementation("io.kotest:kotest-runner-junit5:5.6.2")
    testImplementation("io.kotest:kotest-assertions-core:5.6.2")
    testImplementation("io.kotest:kotest-framework-datatest:5.6.2")
    testImplementation("io.kotest.extensions:kotest-extensions-allure:1.2.0")
    //testImplementation("io.kotest:kotest-extensions-allure:4.4.3") // разобраться
    testImplementation(kotlin("test"))
    testImplementation(kotlin("reflect"))
    implementation("org.slf4j:slf4j-simple:2.0.7")
}

tasks.test {
    useJUnitPlatform {
        // для Kotst убрали
//        includeEngines = setOf("spek2")
//        includeEngines.add("spek2")
        finalizedBy("jacocoTestReport", "allureReport")
    }
}

//tasks.withType<KotlinCompile> {
//    kotlinOptions.jvmTarget = "1.8"
//}

allure {
    autoconfigure = false
    version = "2.13.1"
}