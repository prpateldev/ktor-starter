package com.actonate.repos

import com.actonate.models.Order

interface OrderRepository {
    fun findAll(): List<Order>
    fun findOne(id: String): Order?
}