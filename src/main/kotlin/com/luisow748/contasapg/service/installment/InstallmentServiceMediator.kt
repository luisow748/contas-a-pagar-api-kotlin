package com.luisow748.contasapg.service.installment

import com.luisow748.contasapg.domain.Account
import com.luisow748.contasapg.domain.Installment
import com.luisow748.contasapg.repository.InstallmentRepository
import org.springframework.stereotype.Service

@Service
class InstallmentServiceMediator(
    val installmentRepository: InstallmentRepository,
    val setInstallmentFromAccountService: SetInstallmentFromAccountService
) {
    fun getAll(): List<Installment> {
        return installmentRepository.findAll()
    }

    fun getByAccountId(accountId: Int): List<Installment> {
        return installmentRepository.findByAccount_Id(accountId)
    }

    fun setInstallments(account: Account): Account {
        return setInstallmentFromAccountService.execute(account)
    }
}

