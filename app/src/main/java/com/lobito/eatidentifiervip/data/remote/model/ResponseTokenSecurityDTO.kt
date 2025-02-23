package com.lobito.eatidentifiervip.data.remote.model

import com.google.gson.annotations.SerializedName

data class ResponseTokenSecurityDTO (
    val success : String? = "",
    val message : String? = "",
    @SerializedName("access_token")  val accessToken : String? = "",
    val expiration : String? = "",
    val currentTime : String? = "",
    val tokenType : String? = "",
)