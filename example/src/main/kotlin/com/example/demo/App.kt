package com.example.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

import springfox.documentation.swagger2.annotations.EnableSwagger2


@SpringBootApplication
@EnableSwagger2
class App(

)

fun main(args: Array<String>) {
    SpringApplication(App::class.java)
            .run(*args)

}
