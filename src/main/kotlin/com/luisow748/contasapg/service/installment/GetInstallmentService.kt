package com.luisow748.contasapg.service.installment

import com.luisow748.contasapg.domain.Account
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class GetInstallmentService {
    companion object {
        fun getNewInstallmentValue(account: Account, installmentQty: Int): BigDecimal {
            if (account.totalValue != null) {
                account.installmentValue = getInstallmentValueByAccountTotalValue(account, installmentQty)
                return account.installmentValue!!
            }
            return BigDecimal.ZERO
        }

        private fun getInstallmentValueByAccountTotalValue(account: Account, qdeParcelas: Int): BigDecimal {
            return Optional.of(account).filter { acc -> acc?.totalValue != null }
                .map { acc -> acc.totalValue }
                .map { acc -> acc?.divide(BigDecimal(qdeParcelas)) ?: BigDecimal.ZERO }
                .orElse(BigDecimal.ZERO)
        }
    }
}