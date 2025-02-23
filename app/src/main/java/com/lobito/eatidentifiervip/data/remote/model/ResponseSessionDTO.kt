package com.lobito.eatidentifiervip.data.remote.model

import com.google.gson.annotations.SerializedName

data class ResponseSessionDTO(
    @SerializedName("idUsuario")
    val idUsuario : String,
    @SerializedName("nameUser")
    val nameUser : String,
    @SerializedName("tokenJwt")
    val tokenJwt : String,
)