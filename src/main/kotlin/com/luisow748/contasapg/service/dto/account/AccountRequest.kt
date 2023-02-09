package com.luisow748.contasapg.service.dto.account

import com.luisow748.contasapg.domain.Account
import java.math.BigDecimal

data class AccountRequest(
        val totalValue: BigDecimal?,
        val installmentQty: Int?,
        val installmentValue: BigDecimal?,
        var status: String
)
fun AccountRequest.toEntity() = Account(
        totalValue = totalValue,
        installmentQty = installmentQty,
        installmentValue = installmentValue,
        status = status
)

fun Account.toResponse() = AccountRequest(
        totalValue = totalValue,
        installmentQty = installmentQty,
        installmentValue = installmentValue,
        status = status!!
)