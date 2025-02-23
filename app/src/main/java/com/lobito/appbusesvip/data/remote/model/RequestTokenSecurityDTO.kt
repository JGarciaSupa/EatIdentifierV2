package com.lobito.appbusesvip.data.remote.model

import com.google.gson.annotations.SerializedName

data class RequestTokenSecurityDTO(
    @SerializedName("codigoEmpresa") val codigoEmpresa: String,
    @SerializedName("codigoPais") val codigoPais: String,
    @SerializedName("codigoSistema") val codigoSistema: String,
    @SerializedName("contrasena") val contrasena: String,
    @SerializedName("usuario") val usuario: String
)

