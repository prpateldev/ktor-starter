package com.actonate.routes

import io.ktor.application.*

fun Application.configureRouting() {
    registerCustomerRoutes()
    registerOrderRoutes()
    registerPingRoutes()
}