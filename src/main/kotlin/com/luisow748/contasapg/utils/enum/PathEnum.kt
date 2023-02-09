package com.luisow748.contasapg.utils.enum

const val ACCOUNT = "conta"
enum class PathEnum(val path: String) {
    ACCOUNT_GETALL("/$ACCOUNT"),
    ACCOUNT_SAVE("/$ACCOUNT")
}