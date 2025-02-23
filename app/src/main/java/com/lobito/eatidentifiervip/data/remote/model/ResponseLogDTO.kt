package com.lobito.eatidentifiervip.data.remote.model

data class ResponseLogDTO(
    val result: Any?,
    val cod: String?,
    val msg: String?,
    val exc: String?,
    val errors: List<ResponseErroresDTO>?
)
