//package com.luisow748.contasapg.repository.mongodb
//
//import com.luisow748.contasapg.domain.document.Register
//import org.springframework.data.mongodb.repository.MongoRepository
//import org.springframework.data.mongodb.repository.Query
//import org.springframework.stereotype.Repository
//import java.util.Optional
//
//@Repository
//interface RegisterRepository: MongoRepository<Register, String> {
//    @Query("{'id': ?0}")
//    fun findByAccountId(id: String): Optional<Register>
//
//}