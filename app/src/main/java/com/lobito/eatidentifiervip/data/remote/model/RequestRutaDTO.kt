package com.lobito.eatidentifiervip.data.remote.model

data class RequestRutaDTO(
    var audCrtDate: String? = null,
    var audCrtUser: String? = null,
    var audUpdDate: String? = null, // LocalDate.now().toString(),
    var audUpdUser: String? = null,
    var estado: Boolean? = null,
    var codigoConexion: String? = null,
    var descripcion: String? = null,
    var horaFin: String? = null,
    var horaInicio: String? = null,
    var horasControlador: Int? = null,
    var id: Int? = null,
    var tipo: Int? = null
)