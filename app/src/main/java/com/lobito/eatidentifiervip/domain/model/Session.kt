package com.lobito.eatidentifiervip.domain.model

import com.lobito.eatidentifiervip.data.local.model.SessionEntity
import com.lobito.eatidentifiervip.data.remote.model.ResponseSessionDTO

data class Session(
    val email: String,
    val password: String,
    val idEmpresa: String,
    val idUsuario: String? = "",
    val nameUser: String? = "",
    val state : Int? = 0,
)

fun ResponseSessionDTO.toDomain(email: String, password: String, idEmpresa: String) = Session (
    email = email,
    password = password,
    idEmpresa = idEmpresa,
    idUsuario = idUsuario,
    nameUser = nameUser,
)


fun SessionEntity.toDomain() = Session(
    email = email,
    password = password,
    idEmpresa = idEmpresa,
    idUsuario = idUsuario,
    nameUser = nameUser,
)
