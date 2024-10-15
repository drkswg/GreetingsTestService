package org.drkswg.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class GreetingsController {

    @Get("/greet")
    fun greet() = "Greetings!"
}