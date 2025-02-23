package com.lobito.eatidentifiervip.data.remote.model

import com.google.gson.annotations.SerializedName

data class ResponseEmpresasDTO(
    @SerializedName("Empresa_ID")
    val idEmpresa: String,
    @SerializedName("Razon_Social")
    val razonSocial: String,
    @SerializedName("Razon_Comercial")
    val razonComercial: String,
    @SerializedName("IdentificadorTributario")
    val identificadorTributario: String,
    @SerializedName("Direccion")
    val direccion: String,
    @SerializedName("Telefono")
    val telefono: String,
    @SerializedName("Email")
    val email: String,
    @SerializedName("Fecha_Registro")
    val dateRegistro: String,
    @SerializedName("Fecha_Modificacion")
    val dateModificacion: String,
    @SerializedName("Estado")
    val state: Int
)