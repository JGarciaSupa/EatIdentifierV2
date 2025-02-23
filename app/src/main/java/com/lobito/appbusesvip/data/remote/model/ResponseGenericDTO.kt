package com.lobito.appbusesvip.data.remote.model

data class ResponseGenericDTO<T>(
    val code: String,
    val message: String,
    val result: T,
    val success: Boolean,
)
