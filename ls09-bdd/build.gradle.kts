//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.21"
    id("net.serenity-bdd.serenity-gradle-plugin") version "3.7.0"
}

group = "ru.sindm"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // Serenity - большая библиотека серьезно обновлена + документация
    // https://github.com/serenity-bdd/serenity-junit-starter.git
    // дает все что надо в т.ч. встроенный репортер
    // интегрируется с JUNIT в основном под WEB
    // screenplay - продолжение паттерна PgeObject для Web тестирования
    testImplementation("net.serenity-bdd:serenity-core:3.7.1")
    testImplementation("net.serenity-bdd:serenity-junit5:3.7.1")

    testImplementation("net.serenity-bdd:serenity-screenplay:3.7.1")
    testImplementation("net.serenity-bdd:serenity-ensure:3.7.1")
    testImplementation("net.serenity-bdd:serenity-screenplay-webdriver:3.7.1")

    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
    testImplementation("org.junit.platform:junit-platform-suite:1.9.3")

    // cucumber - самя популярная BDD Система - очень большая система библиотек
    // сайт из-под VPN
    // в Inell ставятся плагины cucumber for Java cucumber for Kotlin и Gherkin
    testImplementation("io.cucumber:cucumber-java8:7.12.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.12.0")

    implementation("org.slf4j:slf4j-simple:2.0.7")


}

tasks.test {
    useJUnitPlatform()
}

//tasks.withType<KotlinCompile> {
//    kotlinOptions.jvmTarget = "1.8"
//}