package com.luisow748.contasapg.fixture

import com.luisow748.contasapg.service.dto.account.AccountRequest
import java.math.BigDecimal

class AccountFixture {
    companion object {
        fun get(id: Int): AccountRequest {
            val totalValue = BigDecimal.valueOf(52.99 * id)
            val installmentQty = 10
            val installmentValue = totalValue / BigDecimal.valueOf(installmentQty.toLong())
            return AccountRequest(
                    totalValue = totalValue,
                    installmentQty,
                    installmentValue,
                   "status: $id"
            )
        }

        fun getList(qty: Int): List<AccountRequest> {
            val accountList: MutableList<AccountRequest> = mutableListOf()
            for (num in qty downTo 1) {
                accountList.add(get(num))
            }
            return accountList
        }

        fun getEmptyInputAccount(): AccountRequest {
            val account = AccountRequest(BigDecimal.ZERO, 10, BigDecimal.ZERO, "not saved yet")
            return account
        }
    }

}