package com.luisow748.contasapg.service.user

import com.luisow748.contasapg.domain.User
import com.luisow748.contasapg.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService {
    private final lateinit var userRepository: UserRepository
    fun save(user: User) : User{
        return userRepository.save(user)
    }
}