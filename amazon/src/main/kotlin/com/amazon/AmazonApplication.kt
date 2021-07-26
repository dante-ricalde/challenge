package com.amazon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AmazonApplication

fun main(args: Array<String>) {
	runApplication<AmazonApplication>(*args)
}
