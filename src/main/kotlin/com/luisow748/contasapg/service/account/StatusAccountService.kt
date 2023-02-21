package com.luisow748.contasapg.service.account

import com.luisow748.contasapg.domain.Account
import org.springframework.stereotype.Service

@Service
class StatusAccountService {

    fun setStatus(account: Account) {
        if (account.status.isNullOrEmpty()) {
            account.status = "pending"
        }
    }
}