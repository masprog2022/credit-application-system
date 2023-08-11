package com.masprogtechs.credit.application.system.repositories

import com.masprogtechs.credit.application.system.entities.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, Long>