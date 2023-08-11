package com.masprogtechs.credit.application.system.repositories

import com.masprogtechs.credit.application.system.entities.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CreditRepository: JpaRepository<Credit, Long>{
    fun findByCreditCode(creditCode: UUID): Credit?
}

