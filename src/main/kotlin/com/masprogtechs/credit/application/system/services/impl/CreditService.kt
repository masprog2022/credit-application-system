package com.masprogtechs.credit.application.system.services.impl

import com.masprogtechs.credit.application.system.entities.Credit
import com.masprogtechs.credit.application.system.repositories.CreditRepository
import com.masprogtechs.credit.application.system.services.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(

    private val creditRepository: CreditRepository,
    private val customerService: CustomerService

): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
         return this.creditRepository.save(credit);
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomerId(customerId)
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = this.creditRepository.findByCreditCode(creditCode) ?:
        throw RuntimeException("Credit code $creditCode not found")

        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin")
    }

}