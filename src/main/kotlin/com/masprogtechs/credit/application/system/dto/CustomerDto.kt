package com.masprogtechs.credit.application.system.dto

import com.masprogtechs.credit.application.system.entities.Address
import com.masprogtechs.credit.application.system.entities.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto (
    @field:NotEmpty(message ="Invalid input") val firstName: String,
    @field:NotEmpty(message ="Invalid input") val lastName: String,
    @field:NotEmpty(message ="Invalid input")
    @CPF(message = "This invalid CPF")
    val cpf: String,
    @field:NotNull(message ="Not null") val income: BigDecimal,
    @field:NotEmpty(message ="Invalid input")
    @field:Email(message ="Not null")val email: String,
    @field:NotEmpty(message ="Invalid input") val password: String,
    @field:NotEmpty(message ="Invalid input") val zipCode: String,
    @field:NotEmpty(message ="Invalid input") val street: String,

    ){
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )




    )
}