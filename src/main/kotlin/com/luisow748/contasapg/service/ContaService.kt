package com.luisow748.contasapg.service

import com.luisow748.contasapg.domain.Conta
import com.luisow748.contasapg.repository.ContaRepository
import org.springframework.stereotype.Service

@Service
class ContaService(
        val contaRepository: ContaRepository,
        val parcelaService: ParcelaService
) {

    fun getAll(): List<Conta> {
        return contaRepository.findAll()
    }

    fun save(conta: Conta) {
        parcelaService.getParcelas(conta).forEach {
            conta.parcelas?.add(it)
        }
        contaRepository.save(conta)
    }
}