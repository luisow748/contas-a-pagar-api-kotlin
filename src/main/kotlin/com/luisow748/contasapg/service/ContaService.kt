package com.luisow748.contasapg.service

import com.luisow748.contasapg.domain.Conta
import com.luisow748.contasapg.repository.ContaRepository
import org.springframework.stereotype.Service
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

@Service
class ContaService(
        val contaRepository: ContaRepository,
        val parcelaService: ParcelaService
) {

//    fun getAll() {
//        return contaRepository.findAll()
//    }

    fun save(conta: Conta) {
        parcelaService.getParcelas(conta).forEach {
            conta.parcelas?.add(it)
        }
        contaRepository.save(conta)
    }
}