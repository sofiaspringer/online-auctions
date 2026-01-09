plugins {
    idea
    kotlin("jvm") version "2.2.20"
    `java-library`
    `java-test-fixtures`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}