package com.actonate.repos

import com.actonate.models.Customer

val customerStorage = mutableListOf<Customer>()

class CustomerRepositoryImpl : CustomerRepository {
    override fun findAll(): List<Customer> {
        return customerStorage
    }

    override fun findOne(id: String): Customer? {
        return customerStorage.find { it.id == id }
    }

    override fun create(customer: Customer): Boolean {
        customerStorage.add(customer)
        return true
    }

    override fun delete(id: String): Boolean {
        if (customerStorage.removeIf { it.id == id }) {
            return true
        }
        return false
    }
}