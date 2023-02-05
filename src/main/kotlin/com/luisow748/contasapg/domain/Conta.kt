package com.luisow748.contasapg.domain

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.Instant
import java.util.*

@Entity
@Table(name = "conta")
class Conta
(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = -1,
        var status: String? = "",
        var valorTotal: BigDecimal? = BigDecimal.ZERO,
        var qdeParcelas: Int? = 0,
        var valorParcela: BigDecimal? = BigDecimal.ZERO,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "conta")
        var parcelas: MutableList<Parcela>? = mutableListOf(),

        var dataCadastro: Date? = Date.from(Instant.now()),
        var dataVencimento: Date? = Date.from(Instant.now())
)


