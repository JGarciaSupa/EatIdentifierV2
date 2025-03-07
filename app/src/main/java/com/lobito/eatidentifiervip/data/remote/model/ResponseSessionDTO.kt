package com.lobito.eatidentifiervip.data.remote.model

import com.google.gson.annotations.SerializedName

data class ResponseSessionDTO(
    @SerializedName("idUsuario")
    val idUsuario : String,
    @SerializedName("userName")
    val nameUser : String,
)