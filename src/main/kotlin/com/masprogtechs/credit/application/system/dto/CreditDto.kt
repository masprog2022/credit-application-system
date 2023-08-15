package com.masprogtechs.credit.application.system.dto

import com.masprogtechs.credit.application.system.entities.Credit
import com.masprogtechs.credit.application.system.entities.Customer
import org.apache.catalina.util.CustomObjectInputStream
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstInstallment: LocalDate,
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