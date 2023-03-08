//package com.luisow748.contasapg.resource
//
//import com.luisow748.contasapg.domain.document.Register
//import com.luisow748.contasapg.service.RegisterService
//import org.springframework.http.HttpStatus
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.*
//
//@CrossOrigin(maxAge = 3600)
//@RestController
//@RequestMapping("/api/register")
//class RegisterController(
//    val registerService: RegisterService
//) {
//
//    @PostMapping
//    fun save(@RequestBody register: Register): ResponseEntity<Register> {
//        val savedRegister = registerService.save(register)
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedRegister)
//    }
//
//    @GetMapping
//    fun getAll(): ResponseEntity<List<Register>> = ResponseEntity.ok(registerService.getAll())
//}