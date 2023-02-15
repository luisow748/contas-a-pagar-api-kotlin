package com.luisow748.contasapg.service.account

import com.luisow748.contasapg.fixture.AccountRequestFixture
import com.luisow748.contasapg.repository.AccountRepository
import com.luisow748.contasapg.service.dto.account.toEntity
import com.luisow748.contasapg.service.installment.InstallmentService
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat

import org.junit.jupiter.api.Test

open class AccountServiceTest {
    private val accountRepository: AccountRepository = mockk()
    private val installmentService: InstallmentService = mockk(relaxed = true)
    private val accountService: AccountService = AccountService(accountRepository, installmentService)

    @Test
    fun shouldSaveAccount() {
        val account = AccountRequestFixture.getWithInstallmentValue(1)
        every { accountRepository.save(any()) } returns account.toEntity()
        val savedAccount = accountService.save(account)
        assertThat(savedAccount).isEqualTo(account)
    }

    @Test
    fun shouldGetAListOfAccounts() {
        val accountList = AccountRequestFixture.getList(10)
        every { accountRepository.findAll() } returns accountList.map { it.toEntity() }
        val accountListReturned = accountService.getAll()
        assertThat(accountListReturned).element(1).isEqualTo(accountList[1])
    }
}