package com.woong.devtimes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DevTimesApplication

fun main(args: Array<String>) {
    runApplication<DevTimesApplication>(*args)
}
