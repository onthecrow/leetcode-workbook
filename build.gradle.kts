plugins {
    kotlin("jvm") version "2.0.0"
}

group = "com.onthecrow"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(kotlin("reflect"))
    implementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    implementation("org.junit.platform:junit-platform-launcher:1.10.0")
    implementation("org.junit.jupiter:junit-jupiter-engine:5.10.0")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}
kotlin {
    jvmToolchain(17)
}