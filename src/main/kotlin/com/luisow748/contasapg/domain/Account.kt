package com.luisow748.contasapg.domain

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.Instant
import java.util.*

@Entity
@Table(name = "account")
class Account
(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = -1,

        var status: String? = "",
        var totalValue: BigDecimal? = BigDecimal.ZERO,
        var installmentQty: Int? = 0,
        var installmentValue: BigDecimal? = BigDecimal.ZERO,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "account")
        var installments: MutableList<Installment>? = mutableListOf(),

        var createdAt: Date? = Date.from(Instant.now()),
        var expirationDate: Date? = Date.from(Instant.now())
)


