package com.luisow748.contasapg.fixture

import com.luisow748.contasapg.service.dto.account.AccountRequest
import java.math.BigDecimal
import java.time.LocalDate

class AccountRequestFixture {
    companion object {
        fun getWithInstallmentValue(id: Int): AccountRequest {
            val totalValue = BigDecimal.valueOf(52.99 * id)
            val installmentQty = 10
            val installmentValue = totalValue / BigDecimal.valueOf(installmentQty.toLong())
            return AccountRequest(
                id = id,
                totalValue = totalValue,
                installmentQty,
                installmentValue,
                "status: $id",
                createdAt = LocalDate.now().toString(),
                expirationDate = LocalDate.now().plusMonths(installmentQty.toLong()).toString()
            )
        }

        fun getList(qty: Int): List<AccountRequest> {
            val accountList: MutableList<AccountRequest> = mutableListOf()
            for (num in qty downTo 1) {
                accountList.add(getWithInstallmentValue(num))
            }
            return accountList
        }

        fun getEmptyInputAccount(): AccountRequest {
            return AccountRequest(
                1,
                BigDecimal.ZERO,
                10,
                BigDecimal.ZERO,
                "not saved yet",
                LocalDate.now().plusMonths(10L).toString(),
                LocalDate.now().plusMonths(10).toString()
                )
        }

        fun getEmptyInputAccountWithoutInstallments(): AccountRequest {
            val emptyInputAccount = getEmptyInputAccount()
            emptyInputAccount.totalValue = BigDecimal.valueOf(9990L)
            return emptyInputAccount
        }
    }

}