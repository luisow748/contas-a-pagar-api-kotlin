package com.luisow748.contasapg

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories

@SpringBootApplication
@EnableRedisRepositories
class ContasapgApplication

fun main(args: Array<String>) {
	runApplication<ContasapgApplication>(*args)
}
