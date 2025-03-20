package com.onthecrow

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val process = ProcessBuilder("./gradlew", "test", "--tests", "TestRunner")
        .redirectErrorStream(true)
        .start()

    BufferedReader(InputStreamReader(process.inputStream)).use { reader ->
        reader.lines().forEach { println(it) }
    }

    val exitCode = process.waitFor()
    println("Gradle test завершился с кодом $exitCode")
}
