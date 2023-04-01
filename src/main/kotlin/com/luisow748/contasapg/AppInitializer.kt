package com.luisow748.contasapg

import com.luisow748.contasapg.domain.Account
import com.luisow748.contasapg.service.account.AccountService
import com.luisow748.contasapg.service.dto.account.toResponse
import com.luisow748.contasapg.service.input.RegisterRequest
import com.luisow748.contasapg.service.security.AuthenticationService
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component
import java.math.BigDecimal


@Component
class AppInitializer (
    val accountService: AccountService,
    val authenticationService: AuthenticationService
) : CommandLineRunner {
    @Throws(Exception::class)
    override fun run(vararg args: String) {

        val user = RegisterRequest(
            firstName = "John Matt",
            lastName = "Petersen",
            email = "j@mat.com",
            password = "123"
        )
        authenticationService.register(user)



        for(i in 1..100){

            val account = Account(
                name = "Conta $i",
                status = "pendente",
                totalValue = getTotalValue(i),
                installmentQty = getInstallmentQty(i),

            )
            accountService.save(account.toResponse())
        }
        val pageRequest = PageRequest.of(0, 50)
        accountService.getAll(pageRequest).map { LOG?.info(it.toString()) }

    }

    companion object {
        private val LOG: org.slf4j.Logger? = LoggerFactory.getLogger(AppInitializer::class.java)
    }

    fun getInstallmentQty(i: Int): Int {
        return if(i < 6){
            5
        }else if (i in 6..12) {
            i
        }else {
            14
        }
    }
    fun getTotalValue(i: Int): BigDecimal {
        var firstValue = (55*i) * (1.1*i)
        if(firstValue > 50000) {
            firstValue /= i
        }

        return BigDecimal.valueOf(firstValue.toLong())
    }
}