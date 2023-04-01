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
        val expirationDate = LocalDate.now().plusMonths(monthsToPay.toLong())
        setDayMonthYearFromExpirationDate(expirationDate, account)

        return account
    }

    fun setDayMonthYearFromExpirationDate(expirationDate: LocalDate, account: Account) {
        if(account.expirationDay == ""){
            account.expirationDay = expirationDate.dayOfMonth.toString()
        }
        if(account.expirationMonth ==""){
            account.expirationMonth = expirationDate.monthValue.toString()
        }
        if(account.expirationYear ==""){
            account.expirationYear = expirationDate.year.toString()
        }
    }


}