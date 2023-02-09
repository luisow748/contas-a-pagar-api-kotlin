package com.luisow748.contasapg.fixture

import com.luisow748.contasapg.domain.Account
import java.math.BigDecimal
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

class AccountFixture {
    companion object {
        fun get(id: Int): Account {
            return Account(
                    id,
                    "status",
                    totalValue = BigDecimal.valueOf(1052.99),
                    10,
                    BigDecimal.valueOf(108.44),
                    mutableListOf(),
                    createdAt = Date.from(Instant.now()),
                    expirationDate = Date.from(Instant.now().plus(10, ChronoUnit.DAYS))
            )
        }

        fun getList(qty: Int): List<Account> {
            val accountList: MutableList<Account> = mutableListOf()
            for (num in qty downTo 1) {
                accountList.add(get(num))
            }
            return accountList
        }
    }

}