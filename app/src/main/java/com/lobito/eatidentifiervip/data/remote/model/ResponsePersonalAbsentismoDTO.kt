package com.lobito.eatidentifiervip.data.remote.model

import com.google.gson.annotations.SerializedName

data class ResponsePersonalAbsentismoDTO(
    @SerializedName("Personal")
    val personal : List<ResponsePersonalDTO>
)