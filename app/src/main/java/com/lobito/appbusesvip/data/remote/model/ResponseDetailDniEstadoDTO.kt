package com.lobito.appbusesvip.data.remote.model

data class ResponseDetailDniEstadoDTO(
    val verificador: Int,
    val dni: String,
    val nombreCompleto: String,
    val prenombres: String,
    val apPrimer: String,
    val apSegundo: String,
    val server: Int,
)