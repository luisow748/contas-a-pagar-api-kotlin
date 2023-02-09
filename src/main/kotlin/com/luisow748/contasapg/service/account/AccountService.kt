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
    fun getAll(): List<AccountRequest> {
        return accountRepository.findAll().map { it.toResponse() }
    }

    fun save(account: AccountRequest): AccountRequest {
        val accountEntity = account.toEntity()
        prepareAccount(accountEntity)
        val savedAccount = accountRepository.save(accountEntity)
        return savedAccount.toResponse()
    }

    fun saveAll(accountInputList: List<AccountRequest>): List<AccountRequest> {
        if (accountInputList.size < 100) {
            return accountInputList.map { save(it) }.toList()
        }
        return emptyList()
    }

    private fun prepareAccount(account: Account) {
        installmentService.setInstallments(account)
    }
}