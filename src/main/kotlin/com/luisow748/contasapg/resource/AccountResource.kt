package com.luisow748.contasapg.resource

import com.luisow748.contasapg.service.account.AccountService
import com.luisow748.contasapg.service.dto.account.AccountRequest
import com.luisow748.contasapg.service.dto.account.toEntity
import com.luisow748.contasapg.service.dto.account.toResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/conta")
class AccountResource(val accountService: AccountService) {

    @GetMapping
    fun getAll(): ResponseEntity<List<AccountRequest>> {
        val accounts = accountService.getAll()
        return ResponseEntity.ok(accounts.map { it.toResponse() })
    }

    @PostMapping
    fun save(@RequestBody accountInput: AccountRequest): ResponseEntity<AccountRequest> {
        val savedAccount = accountService.save(accountInput.toEntity())
        return ResponseEntity.ok(savedAccount.toResponse())
    }

    @PostMapping("/lote")
    fun saveAll(@RequestBody accountInputList: List<AccountRequest>): ResponseEntity<List<AccountRequest>> {
        val savedAccountList = accountService.saveAll(accountInputList)
        if (savedAccountList.isEmpty()) {
            return ResponseEntity.badRequest().build()
        }
        return ResponseEntity.ok(savedAccountList)
    }
}