package com.lobito.appbusesvip.data.remote.model

import com.google.gson.annotations.SerializedName

data class RequestTokenDTO(
    @SerializedName("Password")
    val password: String,
    @SerializedName("Username")
    val username: String
)