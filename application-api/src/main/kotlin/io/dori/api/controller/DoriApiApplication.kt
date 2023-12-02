package io.dori.api.controller

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["io.dori"])
class DoriApiApplication

fun main(args: Array<String>) {
    runApplication<DoriApiApplication>(*args)
}
