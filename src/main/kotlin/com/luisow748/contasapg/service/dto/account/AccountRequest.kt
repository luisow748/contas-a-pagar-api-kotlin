package com.luisow748.contasapg.service.dto.account

import com.luisow748.contasapg.domain.Account
import java.math.BigDecimal

data class AccountRequest(
        var id: Int?,
        var name: String?,
        var totalValue: BigDecimal?,
        var installmentQty: Int?,
        var installmentValue: BigDecimal?,
        var status: String?,
        var createdAt: String?,
        var expirationDay: String?,
        var expirationMonth: String?,
        var expirationYear: String?,
//        var expirationDate: String?,
)
fun AccountRequest.toEntity() = Account(
        id = id,
        totalValue = totalValue,
        installmentQty = installmentQty,
        installmentValue = installmentValue,
        status = status ?: "",
        createdAt = createdAt,
        expirationDay = expirationDay,
        expirationMonth = expirationMonth,
        expirationYear = expirationYear,
        name = name
)

fun Account.toResponse() = AccountRequest(
        id = id,
        totalValue = totalValue,
        installmentQty = installmentQty,
        installmentValue = installmentValue,
        status = status ?: "",
        createdAt = createdAt,
        expirationDay = expirationDay,
        expirationMonth = expirationMonth,
        expirationYear = expirationYear,
        name = name
)