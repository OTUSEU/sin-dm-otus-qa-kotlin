//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.21"
    id("net.serenity-bdd.serenity-gradle-plugin") version "3.0.0"
}

group = "ru.sindm"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
//    testImplementation("net.serenity-bdd:serenity-core:3.7.1")
//    testImplementation("net.serenity-bdd:serenity-junit:3.7.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
    testImplementation("org.junit.platform:junit-platform-suite:1.9.3")
    testImplementation("io.cucumber:cucumber-java8:7.12.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.12.0")


}

tasks.test {
    useJUnitPlatform()
}

//tasks.withType<KotlinCompile> {
//    kotlinOptions.jvmTarget = "1.8"
//}