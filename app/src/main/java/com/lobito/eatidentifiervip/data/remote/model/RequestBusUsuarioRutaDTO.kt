package com.lobito.eatidentifiervip.data.remote.model

data class RequestBusUsuarioRutaDTO(
    var audCrtDate: String? = null, // LocalDate.now().toString(),
    var audCrtUser: String? = null,
    var audUpdDate: String? = null, // LocalDate.now().toString(),
    var audUpdUser: String? = null,
    var estado: Boolean? = null,
    var busUsuario: RequestBusUsuarioDTO? = null, // BusUsuario(),
    var codigoConexion: String? = null,
    var id: Int? = null,
    var ruta: RequestRutaDTO? = null
)

//var audCrtDate: String? = null, // LocalDate.now().toString(),
//var audCrtUser: String? = null,
//var audUpdDate: String? = null, // LocalDate.now().toString(),
//var audUpdUser: String? = null,
//var estado: Boolean? = null,
//var busUsuario: BusUsuario? = null, // BusUsuario(),
//var codigoConexion: String? = null,
//var id: Int? = null,
//var ruta: Ruta? = null
//)