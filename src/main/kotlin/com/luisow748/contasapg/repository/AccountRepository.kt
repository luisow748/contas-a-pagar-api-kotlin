package com.luisow748.contasapg.repository

import com.luisow748.contasapg.domain.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.Month
import java.util.*

@Repository
interface AccountRepository : JpaRepository<Account, Int> {

    override fun findById(id: Int): Optional<Account>

//    @Query("select ac from Account ac where MONTH(ac.expirationDate) = MONTH(:month)")
//    @Query("select ac from Account ac where ")
    fun findByMonth(month: Month): List<Account>

}