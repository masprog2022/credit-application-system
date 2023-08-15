package com.masprogtechs.credit.application.system.dto

import com.masprogtechs.credit.application.system.entities.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message ="Invalid input") val firstName: String,
    @field:NotEmpty(message ="Invalid input") val lastName: String,
    @field:NotNull(message ="Not null")val income: BigDecimal,
    @field:NotEmpty(message ="Invalid input")val zipCode: String,
    @field:NotEmpty(message ="Invalid input")val street: String

) {

    fun toEntity(customer: Customer) : Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street
        return customer
    }
}