package com.actonate.plugins

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureHelloWorldRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
