package com.luisow748.contasapg.service.installment

import com.luisow748.contasapg.domain.Account
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*

@Service
class CreateInstallmentService {
    companion object {
        fun getNewInstallmentValue(account: Account, installmentQty: Int): BigDecimal {
            if (account.totalValue != null) {
                account.installmentValue = getInstallmentValueByAccountTotalValue(account, installmentQty)
                return account.installmentValue!!
            }
            return BigDecimal.ZERO
        }

        private fun getInstallmentValueByAccountTotalValue(account: Account, qdeParcelas: Int): BigDecimal {
//            println("LAST VALUE CALCULATED!!!!! ----------- ***************")
//            println(" Account Nº " + account.id)
//            println("Account TOTAL VALUE: " + account.totalValue)
//            println("Parcelas: $qdeParcelas")

            return Optional.of(account).filter { acc -> acc?.totalValue != null }
                .map { acc -> acc.totalValue }
                .map { acc ->
                    acc?.divide(BigDecimal(qdeParcelas), 2 , RoundingMode.HALF_UP) ?: BigDecimal.ZERO
                }
                .orElse(BigDecimal.ZERO)
        }
    }
}