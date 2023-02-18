package com.luisow748.contasapg.domain.document

import org.springframework.beans.factory.annotation.Value
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.stereotype.Component

@Component
@Document("register")
data class Register(
    @Id
    @Value(" a")
    val id: String? = "",

    @Field(name = "description")
    @Indexed(unique = true)
    var description: String? = "",

    @Field(name = "accountId")
    var accountId: String? = ""

) {
}