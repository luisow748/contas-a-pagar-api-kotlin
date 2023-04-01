package com.luisow748.contasapg.service.account

import com.luisow748.contasapg.domain.Account
import org.springframework.stereotype.Service

@Service
class SetAccountCreditorService {
    fun execute(account: Account){
        if(account.creditor == ""){
            account.creditor = "Credor Abc"
        }
    }
}