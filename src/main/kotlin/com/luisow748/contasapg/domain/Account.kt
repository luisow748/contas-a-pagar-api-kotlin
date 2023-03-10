package com.luisow748.contasapg.domain

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "account")
class Account
    (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = -1,
    var name: String? = "",
    var status: String? = "",
    var totalValue: BigDecimal? = BigDecimal.ZERO,
    var installmentQty: Int? = 0,
    var installmentValue: BigDecimal? = BigDecimal.ZERO,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "account")
    var installments: MutableList<Installment>? = mutableListOf(),

    var createdAt: String? = LocalDate.now().toString(),

    var expirationDay: String? = "",
    var expirationMonth: String? = "",
    var expirationYear: String? = "",
)


