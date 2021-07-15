package com.actonate.routes


import com.actonate.repos.OrderRepository
import com.actonate.repos.OrderRepositoryImpl
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.listOrderRoute() {
    val orderRepository: OrderRepository = OrderRepositoryImpl()
    get("/order") {
        val allOrders = orderRepository.findAll()
        if (allOrders.isNotEmpty()) {
            call.respond(allOrders)
        }
    }
}

fun Route.getOrderRoute() {
    val orderRepository: OrderRepository = OrderRepositoryImpl()

    get("/order/{id}") {
        val id = call.parameters["id"] ?: return@get call.respondText(
            "Bad request",
            status = HttpStatusCode.BadRequest
        )

        val order = orderRepository.findOne(id) ?: return@get call.respondText(
            "Not Found",
            status = HttpStatusCode.NotFound
        )

        call.respond(order)
    }
}


fun Route.totalizeOrderRoute() {
    val orderRepository: OrderRepository = OrderRepositoryImpl()

    get("/order/{id}/total") {
        val id = call.parameters["id"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
        val order = orderRepository.findOne(id) ?: return@get call.respondText(
            "Not Found",
            status = HttpStatusCode.NotFound
        )
        val total = order.contents.map { it.price * it.amount }.sum()
        call.respond(total)
    }
}

fun Application.registerOrderRoutes() {
    routing {
        listOrderRoute()
        getOrderRoute()
        totalizeOrderRoute()
    }
}
