package com.lobito.appbusesvip.data.remote.model

data class RequestRutaDetalleFinDTO(
    var codigoConexion: String? = null,
    var descripcion: String? = null,
    var horaEstimada: String? = null,
    var id: Int? = null,
    var latitud: Double? = null,
    var longitud: Double? = null,
    var ruta: RequestRutaDTO? = null,
    var orden: Int? = null,
)