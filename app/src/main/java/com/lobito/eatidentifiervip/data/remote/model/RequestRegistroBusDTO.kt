package com.lobito.eatidentifiervip.data.remote.model

import com.google.gson.annotations.SerializedName

data class RequestRegistroBusDTO(
    @SerializedName("audCrtUser") var audCrtUser: String,
    @SerializedName("busUsuarioRuta") var busUsuarioRuta: RequestBusUsuarioRutaDTO?,
    @SerializedName("rutaDetalleIni") var rutaDetalleIni: RequestRutaDetalleInicioDTO?,
    @SerializedName("rutaDetalleFin") var rutaDetalleFin: RequestRutaDetalleFinDTO?,
    @SerializedName("codigoConexion") var codigoConexion: String?,
    @SerializedName("flgAlerta") var flgAlerta: Boolean,
    @SerializedName("flgFinalizado") var flgFinalizado: Boolean,
    @SerializedName("lastLatitud") var lastLatitud: Double,
    @SerializedName("lastLongitud") var lastLongitud: Double,
    @SerializedName("horaFin") var horaFin: String?,
    @SerializedName("horaInicio") var horaInicio: String?,
    @SerializedName("id") var id: Int,
    @SerializedName("pasajeros") var pasajeros: Int
)


