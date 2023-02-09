package com.luisow748.contasapg.resource

import com.luisow748.contasapg.domain.Account
import com.luisow748.contasapg.service.account.AccountService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/conta")
class AccountResource(val accountService: AccountService) {

    @GetMapping
    fun getAll(): List<Account> = accountService.getAll()

    @PostMapping
    fun save(@RequestBody account: Account): Account {
       return accountService.save(account)
    }
}