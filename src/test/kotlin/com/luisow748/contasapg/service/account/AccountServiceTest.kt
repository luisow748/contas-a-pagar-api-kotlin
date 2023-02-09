package com.luisow748.contasapg.service.account

import com.luisow748.contasapg.fixture.AccountFixture
import com.luisow748.contasapg.repository.AccountRepository
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
        val account = AccountFixture.get(1)
        every { accountRepository.save(account) } returns account
        val savedAccount = accountService.save(account)
        assertThat(savedAccount).isEqualTo(account)
    }

    @Test
    fun shouldGetAListOfAccounts() {
        val accountList = AccountFixture.getList(10)
        every { accountRepository.findAll() } returns accountList
        val accountListReturned = accountService.getAll()
        assertThat(accountListReturned).element(1).isEqualTo(accountList[1])
    }


}