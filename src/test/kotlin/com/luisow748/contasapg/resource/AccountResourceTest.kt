package com.luisow748.contasapg.resource

import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.luisow748.contasapg.fixture.AccountRequestFixture
import com.luisow748.contasapg.service.account.AccountService
import com.luisow748.contasapg.service.dto.account.AccountRequest
import com.luisow748.contasapg.utils.enum.PathEnum
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class AccountResourceTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var accountService: AccountService
    private lateinit var account: AccountRequest
    private lateinit var inputAccount: AccountRequest

    @BeforeEach
    fun setUp() {
        account = AccountRequestFixture.getWithInstallmentValue(1)
        inputAccount = AccountRequestFixture.getEmptyInputAccount()
        every { accountService.getAll() } returns AccountRequestFixture.getList(10)
        every { accountService.save(any()) } returns account
    }

    @Test
    fun shouldGetAllAccounts() {
        mockMvc.perform(MockMvcRequestBuilders
                .get(PathEnum.ACCOUNT_GETALL.path))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].totalValue").value(529.9))

    }

    @Test
    fun shouldSaveAnAccount() {
        assert(inputAccount.status == "not saved yet")
        mockMvc.perform(MockMvcRequestBuilders
                .post(PathEnum.ACCOUNT_SAVE.path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper().writeValueAsString(inputAccount)))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.totalValue").value(52.99))
    }

    @Test
    fun shouldSaveMoreThanOneAccount() {
        assert(inputAccount.status == "not saved yet")
        mockMvc.perform(MockMvcRequestBuilders
                .post(PathEnum.ACCOUNT_SAVE.path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper().writeValueAsString(inputAccount)))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.totalValue").value(52.99))
    }
}