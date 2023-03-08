//package com.luisow748.contasapg.domain.document
//
//import lombok.AllArgsConstructor
//import lombok.Getter
//import lombok.Setter
//import org.springframework.data.annotation.Id
//import org.springframework.data.mongodb.core.index.Indexed
//import org.springframework.data.mongodb.core.mapping.Document
//import org.springframework.data.mongodb.core.mapping.Field
//import org.springframework.stereotype.Component
//
//@Component
//@Document("register")
//@Getter
//@Setter
//@AllArgsConstructor
//data class Register(
//    @Id
//    val id: String? = null,
//
//    @Field(name = "description")
//    @Indexed(unique = true)
//    var description: String? = "",
//
//    @Field(name = "accountId")
//    var accountId: String? = ""
//
//) {
//}