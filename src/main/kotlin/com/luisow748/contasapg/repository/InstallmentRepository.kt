package com.luisow748.contasapg.repository

import com.luisow748.contasapg.domain.Installment
import org.springframework.data.jpa.repository.JpaRepository

interface InstallmentRepository: JpaRepository<Installment, Int> {
    fun findByAccount_Id(accountId: Int): List<Installment>
}