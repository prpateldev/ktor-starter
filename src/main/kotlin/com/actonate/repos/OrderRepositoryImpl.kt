package com.actonate.repos

import com.actonate.models.Order
import com.actonate.models.OrderItem

val orderStorage = listOf(
    Order(
        "2020-04-06-01", listOf(
            OrderItem("Ham Sandwich", 2, 5.50),
            OrderItem("Water", 1, 1.50),
            OrderItem("Beer", 3, 2.30),
            OrderItem("Cheesecake", 1, 3.75)
        )
    ),
    Order(
        "2020-04-03-01", listOf(
            OrderItem("Cheeseburger", 1, 8.50),
            OrderItem("Water", 2, 1.50),
            OrderItem("Coke", 2, 1.76),
            OrderItem("Ice Cream", 1, 2.35)
        )
    )
)

class OrderRepositoryImpl : OrderRepository {
    override fun findAll(): List<Order> {
        return orderStorage
    }

    override fun findOne(id: String): Order? {
        return orderStorage.find { it.number == id }
    }
}