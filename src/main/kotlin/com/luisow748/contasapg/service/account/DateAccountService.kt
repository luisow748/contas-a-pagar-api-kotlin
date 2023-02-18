package com.luisow748.contasapg.service.account

import com.luisow748.contasapg.domain.Account
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class DateAccountService {
    fun setCreatedDate(account: Account): Account {
        account.createdAt = LocalDate.now().toString()
        return account
    }

    fun setExpirationDate(account: Account): Account {
        if (account.installmentQty != null && account.installmentQty!! > 1) {
            account.expirationDate = account.installmentQty?.let { LocalDate.now().plusMonths(it.toLong()).toString() }
        } else {
            account.expirationDate = LocalDate.now().plusMonths(1).toString()
        }
        return account
    }
}