package com.luisow748.contasapg.utils.enum

const val ACCOUNT = "api/account"
enum class PathEnum(val path: String) {
    ACCOUNT_GETALL("/$ACCOUNT"),
    ACCOUNT_SAVE("/$ACCOUNT")
}