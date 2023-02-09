package com.luisow748.contasapg.service.installment

import com.luisow748.contasapg.domain.Account
import org.springframework.stereotype.Service
import java.math.BigDecimal

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

        private fun getInstallmentValueByAccountTotalValue(account: Account, qdeParcelas: Int) =
                (account.totalValue?.divide(BigDecimal(qdeParcelas)))!!
    }
}