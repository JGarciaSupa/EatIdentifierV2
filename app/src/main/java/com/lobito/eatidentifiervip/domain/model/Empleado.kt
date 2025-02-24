package com.lobito.eatidentifiervip.domain.model

import com.lobito.eatidentifiervip.data.local.model.EmpleadoEntity
import com.lobito.eatidentifiervip.data.remote.model.ResponseEmpleadoDTO

data class Empleado(
    val idEmpleado: String,
    val nombres: String,
    val apellidos: String,
    val fechaNacimiento: String,
    val cui: String,
    val telefono: String,
    val email: String,
    val fechaRegistro: String,
    val estado: Int,
    val idEmpresa: String,
    val idConcesionaria: String,
    val idRole: String
)


fun ResponseEmpleadoDTO.toDomain() = Empleado(
    idEmpleado = idEmpleado,
    nombres = nombres,
    apellidos = apellidos,
    fechaNacimiento = fechaNacimiento,
    cui = cui,
    telefono = telefono,
    email = email,
    fechaRegistro = fechaRegistro,
    estado = estado,
    idEmpresa = idEmpresa,
    idConcesionaria = idConcesionaria,
    idRole = idRole
)

fun EmpleadoEntity.toDomain() = Empleado(
    idEmpleado = idEmpleado,
    nombres = nombres,
    apellidos = apellidos,
    fechaNacimiento = fechaNacimiento,
    cui = cui,
    telefono = telefono,
    email = email,
    fechaRegistro = fechaRegistro,
    estado = estado,
    idEmpresa = idEmpresa,
    idConcesionaria = idConcesionaria,
    idRole = idRole
)

