package com.luisow748.contasapg.service.account

import com.luisow748.contasapg.domain.Account
import com.luisow748.contasapg.repository.AccountRepository
import com.luisow748.contasapg.service.dto.account.AccountRequest
import com.luisow748.contasapg.service.dto.account.toEntity
import com.luisow748.contasapg.service.dto.account.toResponse
import com.luisow748.contasapg.service.installment.InstallmentService
import org.springframework.stereotype.Service

@Service
class AccountService(
        val accountRepository: AccountRepository,
        val installmentService: InstallmentService
) {
    fun getAll(): List<Account> {
        return accountRepository.findAll()
    }

    fun save(account: Account): Account {
        prepareAccount(account)
        return accountRepository.save(account)
    }

    fun saveAll(accountInputList: List<AccountRequest>): List<AccountRequest> {
        if (accountInputList.size < 100) {
            val savedAccountList = accountInputList.map { save(it.toEntity()) }
            return savedAccountList.map { it.toResponse() }
        }
        return emptyList()
    }

    private fun prepareAccount(account: Account) {
        installmentService.setInstallments(account)
    }
}