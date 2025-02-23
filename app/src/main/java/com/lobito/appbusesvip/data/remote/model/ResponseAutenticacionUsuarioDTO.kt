package com.lobito.appbusesvip.data.remote.model

data class ResponseAutenticacionUsuarioDTO(
    val validaUsuario: ValidaUsuarioDTO,
    val usuario: ResponseUsuarioDTO,
    val tokenAutentificacion: String
)