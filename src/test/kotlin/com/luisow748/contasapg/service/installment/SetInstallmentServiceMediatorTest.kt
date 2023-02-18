package com.luisow748.contasapg.service.installment

import com.luisow748.contasapg.domain.Account
import com.luisow748.contasapg.fixture.AccountRequestFixture
import com.luisow748.contasapg.service.dto.account.toEntity
import org.junit.jupiter.api.Test

class SetInstallmentServiceMediatorTest {

    private lateinit var setInstallmentService: SetInstallmentService
    private lateinit var account: Account

    @Test
    fun `should set installments based on an account`(){
        account = AccountRequestFixture.getEmptyInputAccountWithoutInstallments().toEntity()
        setInstallmentService = SetInstallmentService()
        account.installments?.let { assert(it.isEmpty()) }
        account.installmentQty?.let { assert(it == 10) }
//        val accountWithInstallment = setInstallmentService.execute(account)
//        account.installments?.let { assert(it.isNotEmpty()) }
    }
}