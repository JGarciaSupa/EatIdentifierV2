package com.lobito.eatidentifiervip.data.remote.model

import com.google.gson.annotations.SerializedName

data class ResponseEmpleadoDTO(
    @SerializedName("Empleado_ID")
    val idEmpleado: String,
    @SerializedName("Nombres")
    val nombres: String,
    @SerializedName("Apellidos")
    val apellidos: String,
    @SerializedName("Fecha_Nacimiento")
    val fechaNacimiento: String,
    @SerializedName("CUI")
    val cui: String,
    @SerializedName("Telefono")
    val telefono: String,
    @SerializedName("Email")
    val email: String,
    @SerializedName("Fecha_Registro")
    val fechaRegistro: String,
    @SerializedName("Estado")
    val estado: Int,
    @SerializedName("Empresa_ID")
    val idEmpresa: String,
    @SerializedName("Concesionaria_ID")
    val idConcesionaria: String,
    @SerializedName("Role_ID")
    val idRole: String
)