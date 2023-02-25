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
        val monthsToPay = account.installmentQty ?: 1
        val localDate = LocalDate.now().plusMonths(monthsToPay.toLong())
        account.expirationDay = account.expirationDay ?: localDate.dayOfMonth.toString()
        account.expirationMonth = account.expirationMonth ?: localDate.monthValue.toString()
        account.expirationYear = account.expirationYear ?: localDate.year.toString()
        return account
    }
}