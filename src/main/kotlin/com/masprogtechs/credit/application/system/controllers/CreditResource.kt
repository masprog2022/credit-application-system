package com.masprogtechs.credit.application.system.controllers

import com.masprogtechs.credit.application.system.dto.CreditDto
import com.masprogtechs.credit.application.system.dto.CreditView
import com.masprogtechs.credit.application.system.dto.CreditViewList
import com.masprogtechs.credit.application.system.entities.Credit
import com.masprogtechs.credit.application.system.services.impl.CreditService
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/v1/credits")
class CreditResource(
    private val creditService: CreditService
) {

    @PostMapping
    fun saveCredit(@RequestBody creditDto: CreditDto): String {
       val credit: Credit = this.creditService.save(creditDto.toEntity())
        return "Credit ${credit.creditCode} - Customer ${credit.customer?.firstName} saved!"
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long) : List<CreditViewList>{
       return this.creditService.findAllByCustomer(customerId).stream()
           .map { credit: Credit -> CreditViewList(credit) }.collect(Collectors.toList())
    }

    @GetMapping
    fun findByCreditCode(@RequestParam(value = "customerId") customerId: Long, @PathVariable creditCode: UUID): CreditView {
       val credit: Credit = this.creditService.findByCreditCode(customerId, creditCode)
        return CreditView(credit)
    }
}