package com.lobito.eatidentifiervip.data.remote.model

import com.google.gson.annotations.SerializedName

data class RequestBusDTO(
    @SerializedName("audCrtDate")
    var audCrtDate: String? = null,
    @SerializedName("audCrtUser")
    var audCrtUser: String? = null,
    @SerializedName("audUpdDate")
    var audUpdDate: String? = null,
    @SerializedName("audUpdUser")
    var audUpdUser: String? = null,
    @SerializedName("estado")
    var estado: Boolean? = null,
    @SerializedName("capacidad")
    var capacidad: Int? = null,
    @SerializedName("codigoConexion")
    var codigoConexion: String? = null,
    @SerializedName("descripcion")
    var descripcion: String? = null,
    @SerializedName("empresa")
    var empresa: String? = null,
    @SerializedName("flgPropio")
    var flgPropio: Boolean? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("observaciones")
    var observaciones: String? = null,
    @SerializedName("placa")
    var placa: String? = null
)