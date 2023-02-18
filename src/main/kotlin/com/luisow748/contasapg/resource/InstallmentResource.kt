package com.luisow748.contasapg.resource

import com.luisow748.contasapg.domain.Installment
import com.luisow748.contasapg.service.installment.InstallmentServiceMediator
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/installment")
class InstallmentResource(
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