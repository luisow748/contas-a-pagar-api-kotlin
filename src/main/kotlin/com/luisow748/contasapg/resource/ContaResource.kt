package com.luisow748.contasapg.resource

import com.luisow748.contasapg.domain.Conta
import com.luisow748.contasapg.service.ContaService
import com.luisow748.contasapg.service.ParcelaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
//@RequestMapping("/conta")
class ContaResource(val contaService: ContaService) {

//    @GetMapping("/")
//    fun getAll(): List<Conta> = contaService.getAll()

    @PostMapping("/")
    fun save(@RequestBody conta: Conta) {
        contaService.save(conta)
    }
}