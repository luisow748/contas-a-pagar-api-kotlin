package com.luisow748.contasapg.repository;

import com.luisow748.contasapg.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
@Repository
interface UserRepository : JpaRepository<User?, Int?> {
    fun findByEmail(email: String?): Optional<User?>?
}

