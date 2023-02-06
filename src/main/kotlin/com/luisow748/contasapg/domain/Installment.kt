package com.luisow748.contasapg.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
class Installment(

        @JsonIgnore
        @ManyToOne(cascade = [CascadeType.PERSIST])
//        @JoinColumn(name = "conta_id")
        var account: Account = Account(),
        var value: BigDecimal = BigDecimal.ZERO,
        var number: Int = 0,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = -1
)
