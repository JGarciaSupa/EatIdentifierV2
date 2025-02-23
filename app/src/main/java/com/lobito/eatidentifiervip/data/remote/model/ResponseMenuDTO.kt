package com.lobito.eatidentifiervip.data.remote.model

import com.google.gson.annotations.SerializedName

data class ResponseMenuDTO(
    @SerializedName("Menu_ID")
    val idMenu: String,
    @SerializedName("Descripcion")
    val description: String,
    @SerializedName("Fecha_Registro")
    val dateRegister: String,
    @SerializedName("Estado")
    val state: Int,
    @SerializedName("Empresa_ID")
    val idCompany: String,
    @SerializedName("Concesionaria_ID")
    val idConcessionaire: String
)
