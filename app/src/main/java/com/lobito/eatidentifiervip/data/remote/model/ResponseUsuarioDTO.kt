package com.lobito.eatidentifiervip.data.remote.model

data class ResponseUsuarioDTO(
    val id: Int,
    val codigo: String,
    val perfil: ResponsePerfilDTO,
    val nombreEmpresa: String,
    val primerNombre: String,
    val segundoNombre: String,
    val primerApellido: String,
    val segundoApellido: String,
    val nombreCompleto: String,
    val correo: String,
    val telefono: String,
    val usuarioAuditoria: String,
    val fechaAuditoria: String,
    val ipAuditoria: String,
    val estado: Boolean
)