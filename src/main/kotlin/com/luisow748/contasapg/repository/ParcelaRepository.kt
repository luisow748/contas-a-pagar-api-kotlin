package com.luisow748.contasapg.repository

import com.luisow748.contasapg.domain.Parcela
import org.springframework.data.jpa.repository.JpaRepository

//@RepositoryRestResource(path = "parcelas")
interface ParcelaRepository: JpaRepository<Parcela, Int> {
}