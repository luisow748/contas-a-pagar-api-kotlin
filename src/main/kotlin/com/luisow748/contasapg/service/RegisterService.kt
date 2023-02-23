package com.luisow748.contasapg.service

import com.luisow748.contasapg.domain.document.Register
import com.luisow748.contasapg.repository.mongodb.RegisterRepository
import org.springframework.stereotype.Service

@Service
class RegisterService(
    val registerRepository: RegisterRepository
) {
    fun save(register: Register): Register {
        return registerRepository.insert(register)
    }
    fun getAll(): List<Register> = registerRepository.findAll()
}