plugins {
    idea
    kotlin("jvm") version "2.2.20"
    `java-library`
    `java-test-fixtures`
}

group = "org.auctions"
version = "1.0"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    dependencies {
        implementation(platform("org.http4k:http4k-bom:6.0.0.0"))
        implementation("org.http4k:http4k-core")
        implementation("org.http4k:http4k-server-undertow")
        implementation("org.http4k:http4k-format-moshi")

        testImplementation(kotlin("test"))
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}