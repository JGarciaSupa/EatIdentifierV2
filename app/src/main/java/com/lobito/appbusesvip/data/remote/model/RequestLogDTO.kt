package com.lobito.appbusesvip.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RequestLogDTO(
    @SerializedName("priority")
    @Expose
    var priority: String,

    @SerializedName("tag")
    @Expose
    var tag: String,

    @SerializedName("message")
    @Expose
    var message: String,

    @SerializedName("stackTrace")
    @Expose
    var stackTrace: String,

    @SerializedName("dateTime")
    @Expose
    var dateTime: String,

    @SerializedName("user")
    @Expose
    var user: String,

    @SerializedName("longitud")
    @Expose
    var longitud: String,

    @SerializedName("latitud")
    @Expose
    var latitud: String
)