package com.lobito.eatidentifiervip.data.remote.model

data class ValidaUsuarioDTO(
    val identificador: Int,
    val codigoUsuario: String,
    val isAutenticado: Boolean
)