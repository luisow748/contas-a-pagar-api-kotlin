package com.luisow748.contasapg.service.dto.account

import com.luisow748.contasapg.domain.Account
import java.math.BigDecimal

data class AccountRequest(
        var id: Int?,
        var totalValue: BigDecimal?,
        var installmentQty: Int?,
        var installmentValue: BigDecimal?,
        var status: String
)
fun AccountRequest.toEntity() = Account(
        id = id,
        totalValue = totalValue,
        installmentQty = installmentQty,
        installmentValue = installmentValue,
        status = status
)

fun Account.toResponse() = AccountRequest(
        id = id,
        totalValue = totalValue,
        installmentQty = installmentQty,
        installmentValue = installmentValue,
        status = status!!
)