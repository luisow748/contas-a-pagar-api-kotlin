package com.luisow748.contasapg.resource

import com.luisow748.contasapg.service.account.AccountService
import com.luisow748.contasapg.service.dto.account.AccountRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/account")
class AccountResource(val accountService: AccountService) {

    @GetMapping
    fun getAll(): ResponseEntity<List<AccountRequest>> {
        val accounts = accountService.getAll()
        return ResponseEntity.ok(accounts)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<AccountRequest>{
        return ResponseEntity.ok(accountService.getById(id))
    }

    @PostMapping
    fun save(@RequestBody accountInput: AccountRequest): ResponseEntity<AccountRequest> {
        val savedAccount = accountService.save(accountInput)
        return ResponseEntity.ok(savedAccount)
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