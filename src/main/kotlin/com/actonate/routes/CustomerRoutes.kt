package com.actonate.routes

import com.actonate.models.Customer
import com.actonate.repos.CustomerRepository
import com.actonate.repos.CustomerRepositoryImpl
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.customerRouting() {
    val customerRepository: CustomerRepository = CustomerRepositoryImpl()

    route("/customer") {

        get {
            val allCustomers = customerRepository.findAll()
            if (allCustomers.isNotEmpty()) {
                call.respond(allCustomers)
            } else {
                call.respondText("No customer found", status = HttpStatusCode.NotFound)
            }
        }

        get("{id}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing or malformed id",
                status = HttpStatusCode.BadRequest
            )

            val customer = customerRepository.findOne(id) ?: return@get call.respondText(
                "No customer with id $id",
                status = HttpStatusCode.NotFound
            )

            call.respond(customer)
        }

        post {
            val customer = call.receive<Customer>()
            customerRepository.create(customer)
            call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
        }

        delete("{id}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (customerRepository.delete(id)) {
                call.respondText("Customer removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
            }
        }
    }
}


fun Application.registerCustomerRoutes() {
    routing {
        customerRouting()
    }
}
