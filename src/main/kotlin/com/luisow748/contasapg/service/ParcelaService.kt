package com.luisow748.contasapg.service

import com.luisow748.contasapg.domain.Conta
import com.luisow748.contasapg.domain.Parcela
import com.luisow748.contasapg.repository.ParcelaRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ParcelaService(val parcelaRepository: ParcelaRepository) {

    fun save(parcela: Parcela) {
        parcelaRepository.save(parcela)
    }

    fun getParcelas(conta: Conta): List<Parcela> {
        val qdeParcelas: Int = conta.qdeParcelas ?: 0
        if (qdeParcelas > 0) {
            val parcelas: MutableList<Parcela> = mutableListOf()
            val valor: BigDecimal = conta.valorParcela ?: getValor(conta, qdeParcelas)
            for (num in qdeParcelas downTo 1)
                parcelas.add(Parcela(conta = conta, valor = valor, numero = num))
            return parcelas
        }
        return listOf()
    }

    private fun getValor(conta: Conta, qdeParcelas: Int): BigDecimal {
        if (conta.valorTotal != null) {
            conta.valorParcela = getValorParcelaPeloValorTotalConta(conta, qdeParcelas)
            return conta.valorParcela!!
        }
        return BigDecimal.ZERO
    }

    private fun getValorParcelaPeloValorTotalConta(conta: Conta, qdeParcelas: Int) =
        (conta.valorTotal?.divide(BigDecimal(qdeParcelas)))!!

}

