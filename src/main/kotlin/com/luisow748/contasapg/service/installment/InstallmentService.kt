package com.luisow748.contasapg.service.installment

import com.luisow748.contasapg.domain.Account
import com.luisow748.contasapg.domain.Installment
import com.luisow748.contasapg.repository.InstallmentRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class InstallmentService(val installmentRepository: InstallmentRepository) {

    fun setInstallments(account: Account) {
        val installmentQty: Int = account.installmentQty ?: 0
        if (installmentQty > 0) {
            val installmentValue: BigDecimal = account.installmentValue ?: getNewInstallmentValue(account, installmentQty)
            for (num in installmentQty downTo 1)
                account.installments?.add(Installment(account = account, value = installmentValue, number = num))
        }
    }

    private fun getNewInstallmentValue(account: Account, qdeParcelas: Int): BigDecimal {
        if (account.totalValue != null) {
            account.installmentValue = getInstallmentValueByAccountTotalValue(account, qdeParcelas)
            return account.installmentValue!!
        }
        return BigDecimal.ZERO
    }

    private fun getInstallmentValueByAccountTotalValue(account: Account, qdeParcelas: Int) =
        (account.totalValue?.divide(BigDecimal(qdeParcelas)))!!

}

