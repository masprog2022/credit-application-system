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
        TODO("Not yet implemented")
    }

    override fun findByCreditCode(creditCode: UUID): Credit {
        TODO("Not yet implemented")
    }

}