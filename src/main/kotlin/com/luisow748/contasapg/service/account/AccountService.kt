package com.luisow748.contasapg.service.account

import com.luisow748.contasapg.domain.Account
import com.luisow748.contasapg.repository.ContaRepository
import com.luisow748.contasapg.service.installment.InstallmentService
import org.springframework.stereotype.Service

@Service
class AccountService(
        val contaRepository: ContaRepository,
        val installmentService: InstallmentService
) {
    fun getAll(): List<Account> {
        return contaRepository.findAll()
    }

    fun save(account: Account): Account {
        prepareAccount(account)
        return contaRepository.save(account)
    }

    private fun prepareAccount(account: Account) {
        installmentService.setInstallments(account)
    }
}