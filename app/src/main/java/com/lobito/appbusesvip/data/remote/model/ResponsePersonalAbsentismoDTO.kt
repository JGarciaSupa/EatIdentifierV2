package com.lobito.appbusesvip.data.remote.model

import com.google.gson.annotations.SerializedName

data class ResponsePersonalAbsentismoDTO(
    @SerializedName("Personal")
    val personal : List<ResponsePersonalDTO>
)