package com.actonate

import com.actonate.plugins.configureHTTP
import com.actonate.plugins.configureMonitoring
import com.actonate.plugins.configureSerialization
import com.actonate.routes.configureRouting
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureHTTP()
        configureRouting()
        configureSerialization()
        configureMonitoring()
    }.start(wait = true)
}
