package com.luisow748.contasapg.service.installment

import com.luisow748.contasapg.domain.Account
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class DateInstallmentService {

    fun getFirstExpiringDate(account: Account): LocalDate {
        return if (account.firstExpirationYear == 0 || account.firstExpirationMonth == 0 || account.firstExpirationDay == 0) {
            LocalDate.now()
        } else {
            LocalDate.of(
                account.firstExpirationYear ?: 0,
                account.firstExpirationMonth ?: 0,
                account.firstExpirationDay ?: 0
            )
        }
    }

    fun getExpiringDay(firstExpiringDate: LocalDate, installmentNumber: Int): String {
        return firstExpiringDate.plusMonths(installmentNumber.toLong()).dayOfMonth.toString()

    }
    fun getExpiringMonth(firstExpiringDate: LocalDate, installmentNumber: Int): String {
        return firstExpiringDate.plusMonths(installmentNumber.toLong()).monthValue.toString()

    }
    fun getExpiringYear(firstExpiringDate: LocalDate, installmentNumber: Int): String {
        return firstExpiringDate.plusMonths(installmentNumber.toLong()).year.toString()

    }

//    fun getExpiringDateFromInstallmentNumber(account: Account, installmentNumber: Number): LocalDate? {
//        val firstExpiringDate =  getFirstExpiringDate(account)?.plusMonths(installmentNumber.toLong())
//
//    }
}