package com.masprogtechs.credit.application.system.controllers

import com.masprogtechs.credit.application.system.dto.CustomerDto
import com.masprogtechs.credit.application.system.dto.CustomerView
import com.masprogtechs.credit.application.system.entities.Customer
import com.masprogtechs.credit.application.system.services.impl.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/customers")
class CustomerResource(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String {
       val saveCustomer = this.customerService.save(customerDto.toEntity())
        return "Customer ${saveCustomer.email} saved!"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerView {
       val customer: Customer = this.customerService.findById(id)
        return CustomerView(customer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)
}