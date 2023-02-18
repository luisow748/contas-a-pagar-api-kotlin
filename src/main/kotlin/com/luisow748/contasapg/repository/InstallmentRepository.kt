package com.luisow748.contasapg.repository

import com.luisow748.contasapg.domain.Installment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InstallmentRepository: JpaRepository<Installment, Int> {
    fun findByAccount_Id(accountId: Int): List<Installment>
}