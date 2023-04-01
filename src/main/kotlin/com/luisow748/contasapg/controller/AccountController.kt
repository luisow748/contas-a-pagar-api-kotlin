package com.luisow748.contasapg.controller

import com.luisow748.contasapg.service.account.AccountService
import com.luisow748.contasapg.service.dto.account.AccountRequest
import com.luisow748.contasapg.service.dto.account.toResponse
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

//@CrossOrigin(maxAge = 3600, origins = ["http://localhost:**"])
@RestController
@RequestMapping("/api/account")
class AccountController(val accountService: AccountService) {

    @GetMapping
    fun getAll(@RequestParam page: Int): ResponseEntity<List<AccountRequest>> {
//        val accounts = accountService.getAll()
//        return ResponseEntity.ok(accounts)
        val pageRequest = PageRequest.of(page, 10)
        return ResponseEntity.ok(accountService.getAll(pageRequest).map { it.toResponse() })
    }

    @GetMapping("/total")
    fun getTotalAccounts(): Int {
        return accountService.getTotalAccounts()
    }

    @GetMapping("/{id}")
    fun getById(
        @PathVariable id: Int): ResponseEntity<AccountRequest>{
        return ResponseEntity.ok(accountService.getById(id))
    }

    @GetMapping("/month")
    fun getByMonth(
        @RequestParam month: String,
        @RequestParam year: String): ResponseEntity<List<AccountRequest>>{
        return ResponseEntity.ok(accountService.getByMonth(month, year))
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

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<String> {
        accountService.delete(id)
        return ResponseEntity.ok().build()
    }
    @PostMapping("/fakes")
    fun saveFakes(): ResponseEntity<List<AccountRequest>> {
        return ResponseEntity.ok(
//            accountService.saveFakes()
        ).build()
    }
}