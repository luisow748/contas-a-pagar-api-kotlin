package com.luisow748.contasapg.service.installment

import com.luisow748.contasapg.domain.Account
import org.springframework.stereotype.Service

@Service
class InstallmentService(
        val setInstallmentService: SetInstallmentService
) {

    fun setInstallments(account: Account) {
        setInstallmentService.execute(account)
    }

}

