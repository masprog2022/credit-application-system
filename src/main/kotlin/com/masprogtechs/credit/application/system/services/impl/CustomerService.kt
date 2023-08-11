package com.masprogtechs.credit.application.system.services.impl

import com.masprogtechs.credit.application.system.entities.Customer
import com.masprogtechs.credit.application.system.repositories.CustomerRepository
import com.masprogtechs.credit.application.system.services.ICustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService (
    private val customerRepository: CustomerRepository
        ): ICustomerService{

    override fun save(customer: Customer): Customer {
        return this.customerRepository.save(customer)
    }

    override fun findById(id: Long): Customer {
       return this.customerRepository.findById(id).orElseThrow{
           throw RuntimeException("Id $id not found!")
       }
    }

    override fun delete(id: Long) {
        this.customerRepository.deleteById(id)
    }
}