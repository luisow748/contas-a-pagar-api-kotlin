package com.luisow748.contasapg.service.installment

import com.luisow748.contasapg.domain.Account
import com.luisow748.contasapg.domain.Installment
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class SetInstallmentService {
    fun execute(account: Account) {
        val installmentQty: Int = account.installmentQty ?: 0
        if (installmentQty > 0) {
            val installmentValue: BigDecimal = account.installmentValue
                    ?: GetInstallmentService.getNewInstallmentValue(account, installmentQty)
            for (num in installmentQty downTo 1)
                account.installments?.add(Installment(account = account, value = installmentValue, number = num))
        }
    }
}