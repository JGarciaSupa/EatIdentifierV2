package com.lobito.eatidentifiervip.data.remote.model

data class ResponsePerfilDTO(
    val id: Int,
    val descripcion: String,
    val usuarioAuditoria: String,
    val fechaAuditoria: String,
    val ipAuditoria: String,
    val estado: Boolean
)