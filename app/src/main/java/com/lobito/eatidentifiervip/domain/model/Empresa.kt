package com.lobito.eatidentifiervip.domain.model

import com.lobito.eatidentifiervip.data.local.model.EmpresaEntity
import com.lobito.eatidentifiervip.data.remote.model.ResponseEmpresasDTO

data class Empresa(
    val idEmpresa : String,
    val razonSocial : String,
    val razonComercial: String,
    val identificadorTributario: String,
    val direccion: String,
    val telefono: String,
    val email: String,
    val dateRegistro: String,
    val dateModificacion: String,
    val state: Int
)

fun ResponseEmpresasDTO.toDomain() = Empresa(
    idEmpresa = idEmpresa,
    razonSocial = razonSocial,
    razonComercial = razonComercial,
    identificadorTributario = identificadorTributario,
    direccion = direccion,
    telefono = telefono,
    email = email,
    dateRegistro = dateRegistro,
    dateModificacion =dateModificacion,
    state = state
)

fun EmpresaEntity.toDomain() = Empresa(
    idEmpresa = idEmpresa,
    razonSocial = razonSocial,
    razonComercial = razonComercial,
    identificadorTributario = identificadorTributario,
    direccion = direccion,
    telefono = telefono,
    email = email,
    dateRegistro = dateRegistro,
    dateModificacion =dateModificacion,
    state = state
)