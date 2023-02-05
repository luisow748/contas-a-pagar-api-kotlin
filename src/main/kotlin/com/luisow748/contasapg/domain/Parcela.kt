package com.luisow748.contasapg.domain

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
class Parcela(

        @ManyToOne(cascade = [CascadeType.PERSIST])
//        @JoinColumn(name = "conta_id")
        var conta: Conta = Conta(),
        var valor: BigDecimal = BigDecimal.ZERO,
        var numero: Int = 0,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = -1
)
