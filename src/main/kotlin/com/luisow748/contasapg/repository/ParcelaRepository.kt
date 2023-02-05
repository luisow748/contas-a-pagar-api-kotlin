package com.luisow748.contasapg.repository

import com.luisow748.contasapg.domain.Parcela
import org.springframework.data.repository.CrudRepository

interface ParcelaRepository: CrudRepository<Parcela, Int> {
}