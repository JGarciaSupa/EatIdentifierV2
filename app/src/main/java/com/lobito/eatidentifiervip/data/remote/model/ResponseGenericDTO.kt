package com.lobito.eatidentifiervip.data.remote.model

data class ResponseGenericDTO<T>(
    val message : String? = "",
    val success : Boolean? = false,
    val data: T? = null,
    val error : String? = ""
)

