package com.masprogtechs.credit.application.system.services

import com.masprogtechs.credit.application.system.entities.Customer

interface ICustomerService {

   fun save(customer: Customer): Customer

   fun findById(id: Long): Customer

   fun delete(id: Long): Customer
}