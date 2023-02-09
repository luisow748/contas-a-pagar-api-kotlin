package com.luisow748.contasapg.repository

import com.luisow748.contasapg.domain.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Int> {



}