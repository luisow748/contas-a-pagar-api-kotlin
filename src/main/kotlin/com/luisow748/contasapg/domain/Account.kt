package com.luisow748.contasapg.domain

import com.fasterxml.jackson.annotation.JsonBackReference
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

    var creditor: String? = "",

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "account")
    @JsonBackReference
    var installments: MutableList<Installment>? = mutableListOf(),

    var createdAt: String? = LocalDate.now().toString(),
    var firstExpirationDay: Int? = 0,
    var firstExpirationMonth: Int? = 0,
    var firstExpirationYear: Int? = 0,

    var expirationDay: String? = "",
    var expirationMonth: String? = "",
    var expirationYear: String? = "",
)


