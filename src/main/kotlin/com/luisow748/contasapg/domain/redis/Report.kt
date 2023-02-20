package com.luisow748.contasapg.domain.redis

import com.luisow748.contasapg.domain.Installment
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@RedisHash("Reports")
data class Report (
    @Indexed val name: String? = "name",
    val month: String? = "month",
    val installments: List<Installment>? = mutableListOf()
) {
    @get:Id
    var id: String? = null
}
