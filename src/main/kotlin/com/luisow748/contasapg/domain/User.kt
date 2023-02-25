package com.luisow748.contasapg.domain

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = -1,
    val fullname: String = "",
    val email: String = "",
    var password: String = ""
)
{}