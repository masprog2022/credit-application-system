package com.masprogtechs.credit.application.system.dto

import com.masprogtechs.credit.application.system.entities.Credit
import com.masprogtechs.credit.application.system.entities.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.apache.catalina.util.CustomObjectInputStream
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message ="Invalid input") val creditValue: BigDecimal,
    @field:Future val dayFirstInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}