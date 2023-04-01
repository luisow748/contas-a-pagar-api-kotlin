package com.luisow748.contasapg.service.installment

import com.luisow748.contasapg.domain.Account
import com.luisow748.contasapg.domain.Installment
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class SetInstallmentFromAccountService(
    val dateInstallmentService: DateInstallmentService
) {
    fun execute(account: Account): Account {
        val installmentQty: Int = account.installmentQty ?: 0
        if (installmentQty > 0) {
            val installmentValue: BigDecimal = getInstallmentValue(account, installmentQty)
            for (num in installmentQty downTo 1) {
                val expiringDate = dateInstallmentService.getFirstExpiringDate(account)
                account.installments?.add(
                    Installment(
                        account = account,
                        accountNumber = account.id,
                        value = installmentValue,
                        number = num,
                        name = "Parcela da conta " + account.name,
                        status = "pendente",
                        creditorName = account.creditor ?: ("Credor da conta " + account.name),
                        paidValue = BigDecimal.ZERO,
                        expirationDay = dateInstallmentService.getExpiringDay(expiringDate, num),
                        expirationMonth = dateInstallmentService.getExpiringMonth(expiringDate, num),
                        expirationYear = dateInstallmentService.getExpiringYear(expiringDate, num)
                    ),
                )
            }

        }
        return account
    }

    private fun getInstallmentValue(
        account: Account,
        installmentQty: Int
    ): BigDecimal {
        return if (account.installmentValue == BigDecimal.ZERO) {
            CreateInstallmentService.getNewInstallmentValue(account, installmentQty)
        } else {
            if (account.installmentValue != null) {
                account.installmentValue!!
            } else {
                BigDecimal.ZERO
            }
        }
    }
}