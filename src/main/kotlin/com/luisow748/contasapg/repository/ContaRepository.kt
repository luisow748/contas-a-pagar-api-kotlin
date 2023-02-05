package com.luisow748.contasapg.repository

import com.luisow748.contasapg.domain.Conta
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "contas")
interface ContaRepository : CrudRepository<Conta, Int> {



}