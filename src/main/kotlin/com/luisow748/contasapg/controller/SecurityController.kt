package com.luisow748.contasapg.controller;

import com.luisow748.contasapg.service.input.AuthenticationRequest
import com.luisow748.contasapg.service.input.AuthenticationResponse
import com.luisow748.contasapg.service.input.RegisterRequest
import com.luisow748.contasapg.service.security.AuthenticationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class SecurityController(
    private val authenticationService: AuthenticationService
) {
    @PostMapping("/register")
    fun register(
        @RequestBody request: RegisterRequest
    ): ResponseEntity<AuthenticationResponse> {
        val authenticationResponse = authenticationService.register(request)
        return ResponseEntity.ok(authenticationResponse)
    }

    @PostMapping("/authenticate")
    fun authenticate(
        @RequestBody request: AuthenticationRequest
    ): ResponseEntity<AuthenticationResponse> {
        val authenticationResponse = authenticationService.authenticate(request)
        return ResponseEntity.ok(authenticationResponse)
    }
}
