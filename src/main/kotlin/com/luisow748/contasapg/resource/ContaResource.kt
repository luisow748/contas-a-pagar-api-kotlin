package com.luisow748.contasapg.resource

import com.luisow748.contasapg.domain.Conta
import com.luisow748.contasapg.service.ContaService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/conta")
class ContaResource(val contaService: ContaService) {

    @GetMapping
    fun getAll(): List<Conta> = contaService.getAll()

    @PostMapping
    fun save(@RequestBody conta: Conta) {
        contaService.save(conta)
    }
}