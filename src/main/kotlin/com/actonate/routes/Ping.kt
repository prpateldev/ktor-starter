package com.actonate.routes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.pingRouting() {
    route("/ping") {
        get {
            call.respondText("PONG")
        }
    }
}

fun Application.registerPingRoutes() {
    routing {
        pingRouting()
    }
}
