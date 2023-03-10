package com.luisow748.contasapg.service.account

import com.luisow748.contasapg.domain.Account
import com.luisow748.contasapg.repository.AccountRepository
import com.luisow748.contasapg.service.dto.account.AccountRequest
import com.luisow748.contasapg.service.dto.account.toEntity
import com.luisow748.contasapg.service.dto.account.toResponse
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class AccountService(
    val accountRepository: AccountRepository,
    val accountServiceMediator: AccountServiceMediator
) {
    fun getAll(): List<AccountRequest> {
        return accountRepository.findAll().map { it.toResponse() }
    }

    fun getById(id: Int): AccountRequest {
        return accountRepository.findById(id).orElse(Account()).toResponse()
    }

    fun getByMonth(month: String, year: String): List<AccountRequest> {
        return accountRepository.findByExpirationMonthAndExpirationYear(month, year)
            .map { it.toResponse() }
    }

    fun save(account: AccountRequest): AccountRequest {
        val accountEntity = account.toEntity()
        accountServiceMediator.prepareAccount(accountEntity)
        val savedAccount = accountRepository.save(accountEntity)
        return savedAccount.toResponse()
    }

    fun saveAll(accountInputList: List<AccountRequest>): List<AccountRequest> {
        if (accountInputList.size < 100) {
            return accountInputList.map { save(it) }.toList()
        }
        return emptyList()
    }

    fun delete(id: Int){
        accountRepository.deleteById(id)
    }

    fun saveFakes(): List<AccountRequest> {
        val accountList = mutableListOf<AccountRequest>()
        for (index in 1..25) {
            val accountRequest = AccountRequest(
                index,
                "Account nº $index",
                BigDecimal.valueOf((100..8000).random().toDouble()),
                (1..12).random(),
                BigDecimal.ZERO,
                "pending",
                "",
                (1..31).random().toString(),
                null,
                null
            )
            accountList.add(save(accountRequest))
        }
        return accountList
    }


}