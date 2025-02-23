package com.lobito.appbusesvip.data.remote.model

data class ResponseLogDTO(
    val result: Any?,
    val cod: String?,
    val msg: String?,
    val exc: String?,
    val errors: List<ResponseErroresDTO>?
)
