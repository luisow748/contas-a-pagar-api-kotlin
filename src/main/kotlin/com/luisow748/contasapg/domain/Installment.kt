package com.luisow748.contasapg.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
class Installment(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = -1,
        var name : String?,
        var number: Int = 0,

        @ManyToOne(cascade = [CascadeType.PERSIST])
        @JsonIgnore
        var account: Account,
        var accountNumber: Int? =0,
        var status: String? = "",
        var creditorName: String? = "",
        var value: BigDecimal = BigDecimal.ZERO,
        var paidValue: BigDecimal? = BigDecimal.ZERO,

        var createdAt: String? = LocalDate.now().toString(),
        var expirationDay: String? = "",
        var expirationMonth: String? = "",
        var expirationYear: String? = "",

        )
