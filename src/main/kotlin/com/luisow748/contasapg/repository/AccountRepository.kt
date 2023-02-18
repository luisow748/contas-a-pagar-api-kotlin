package com.luisow748.contasapg.repository

import com.luisow748.contasapg.domain.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccountRepository : JpaRepository<Account, Int> {

    override fun findById(id: Int): Optional<Account>

}