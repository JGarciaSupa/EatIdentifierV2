package com.lobito.appbusesvip.data.remote.model

data class RequestBusUsuarioDTO(
    var audCrtDate: String? = null, // LocalDate.now().toString(),
    var audCrtUser: String? = null,
    var audUpdDate: String? = null, // LocalDate.now().toString(),
    var audUpdUser: String? = null,
    var estado: Boolean? = null,
    var bus: RequestBusDTO? = null,
    var codigoConexion: String? = null,
    var id: Int? = null,
    var idUsuario: Int? = null,
)