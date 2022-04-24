package com.metehanbolat.businesslevelcryptoapp.model.error

data class Status(
    val credit_count: Int,
    val elapsed: Int,
    val error_message: String,
    val timestamp: String
)