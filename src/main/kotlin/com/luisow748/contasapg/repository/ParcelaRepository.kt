package com.luisow748.contasapg.repository

import com.luisow748.contasapg.domain.Parcela
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "parcelas")
interface ParcelaRepository: CrudRepository<Parcela, Int> {
}