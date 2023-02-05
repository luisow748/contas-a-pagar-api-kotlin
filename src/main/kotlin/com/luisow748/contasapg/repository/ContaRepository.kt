package com.luisow748.contasapg.repository

import com.luisow748.contasapg.domain.Conta
import org.springframework.data.jpa.repository.JpaRepository


//@RepositoryRestResource(path = "contas")
interface ContaRepository : JpaRepository<Conta, Int> {



}