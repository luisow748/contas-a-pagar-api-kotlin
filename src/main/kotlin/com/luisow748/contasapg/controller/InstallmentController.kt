package com.luisow748.contasapg.controller

import com.luisow748.contasapg.domain.Installment
import com.luisow748.contasapg.service.installment.InstallmentServiceMediator
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

//@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/installment")
class InstallmentController(
    val installmentServiceMediator: InstallmentServiceMediator
) {
    @GetMapping
    fun getAll(): ResponseEntity<List<Installment>>{
        return ResponseEntity.ok(installmentServiceMediator.getAll())
    }

    @GetMapping("/{accountId}")
    fun getByAccountId(@PathVariable accountId: Int): ResponseEntity<List<Installment>> {
        return ResponseEntity.ok(installmentServiceMediator.getByAccountId(accountId))
    }
}