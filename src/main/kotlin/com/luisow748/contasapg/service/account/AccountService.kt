package com.luisow748.contasapg.service.account

import com.luisow748.contasapg.domain.Account
import com.luisow748.contasapg.repository.AccountRepository
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

    private fun prepareAccount(account: Account) {
        installmentService.setInstallments(account)
    }
}