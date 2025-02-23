package com.lobito.appbusesvip.data.remote.model

import com.google.gson.annotations.SerializedName

data class ResponsePersonalDTO(
    var absentismo: String? = "",
    @SerializedName("apellido_mat")
    var apellidoMat: String = "",
    @SerializedName("apellido_pat")
    var apellidoPat: String="",
    var area: String="",
    @SerializedName("area_nombre")
    var areaNombre: String="",
    @SerializedName("cod_empresa")
    var codEmpresa: String="",
    @SerializedName("cod_nacionalidad")
    var codNacionalidad: String="",
    @SerializedName("cod_trabajador")
    var codTrabajador: String="",
    var descripcion: String?="",
    var dni: String="",
    var email: String="",
    var estado: String="",
    @SerializedName("estado_civil")
    var estadoCivil: String="",
    var fingreso: String="",
    @SerializedName("Fnacimiento")
    var fnacimiento: String="",
    var funcion: String="",
    @SerializedName("funcion_nombre")
    var funcionNombre: String="",
    @SerializedName("horas_absen")
    var horasAbsen: Any="",
    @SerializedName("licencia_desc")
    var licenciaDesc: String?="",//?
    var nacionalidad: String="",
    var nombres: String="",
    var posicion: String="",
    @SerializedName("posicion_nombre")
    var posicionNombre: String="",
    var sede: String="",
    @SerializedName("sede_nombre")
    var sedeNombre: String="",
    var sexo: String=""
)