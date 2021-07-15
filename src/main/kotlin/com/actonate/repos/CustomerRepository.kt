package com.actonate.repos

import com.actonate.models.Customer

interface CustomerRepository {
    fun findAll(): List<Customer>
    fun findOne(id: String): Customer?

    fun create(customer: Customer): Boolean
    fun delete(id: String): Boolean
}