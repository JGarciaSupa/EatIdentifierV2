package com.lobito.appbusesvip.data.remote.model

data class RequestLoginDTO(
    val codigoEmpresa: String,
    val codigoPais: String,
    val codigoSistema: String,
    val contrasena: String,
    val usuario: String
)