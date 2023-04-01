package com.luisow748.contasapg.service.security

import com.luisow748.contasapg.config.JwtService
import com.luisow748.contasapg.domain.Role
import com.luisow748.contasapg.domain.User
import com.luisow748.contasapg.repository.UserRepository
import com.luisow748.contasapg.service.input.AuthenticationRequest
import com.luisow748.contasapg.service.input.AuthenticationResponse
import com.luisow748.contasapg.service.input.RegisterRequest
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class AuthenticationService(
    val userRepository: UserRepository,
    val passwordEncoder: PasswordEncoder,
    val jwtService: JwtService,
    val authenticationManager: AuthenticationManager,
    ) {
    fun register(request: RegisterRequest): AuthenticationResponse {
        val user = User(
            firstName = request.firstName,
            lastName = request.lastName,
            email = request.email,
            password = passwordEncoder.encode(request.password),
            role = Role.USER
        )
        userRepository.save(user)
        val jwtToken: String = jwtService.generateToken(user)
        return AuthenticationResponse(
            token = jwtToken,
            username = user.firstName
        )
    }

    fun authenticate(request: AuthenticationRequest): AuthenticationResponse? {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                request.email,
                request.password
            )
        )
        val user: User? = userRepository.findByEmail(request.email)
            ?.orElseThrow()
        val jwtToken: String? = user?.let { jwtService.generateToken(it) }
        return jwtToken?.let {
            AuthenticationResponse(
                token = it,
                username = user.firstName
            )
        }
    }

    fun isTokenValid(token: String): Boolean {
        return jwtService.isTokenExpired(token)
    }
}
