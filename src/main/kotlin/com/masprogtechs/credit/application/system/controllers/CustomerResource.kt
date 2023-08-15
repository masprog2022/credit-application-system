package com.masprogtechs.credit.application.system.controllers

import com.masprogtechs.credit.application.system.dto.CustomerDto
import com.masprogtechs.credit.application.system.dto.CustomerUpdateDto
import com.masprogtechs.credit.application.system.dto.CustomerView
import com.masprogtechs.credit.application.system.entities.Customer
import com.masprogtechs.credit.application.system.services.impl.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerResource(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody @Valid customerDto: CustomerDto): ResponseEntity<String> {
       val saveCustomer = this.customerService.save(customerDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Customer ${saveCustomer.email} saved!")
    }


    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long,
                       @RequestBody @Valid customerUpdateDto: CustomerUpdateDto
    ): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        val customerToUpdate = customerUpdateDto.toEntity(customer)
        val customerUpdated: Customer = this.customerService.save(customerToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView> {
       val customer: Customer = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)

}