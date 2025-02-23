package com.lobito.eatidentifiervip.data.remote.model

import com.google.gson.annotations.SerializedName

data class ResponseIventarioDTO(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("empresa") var empresa: String? = "",
    @SerializedName("gerencia") var gerencia: String? = "",
    @SerializedName("_area") var area: String? = "",
    @SerializedName("sede") var sede: String? = "",
    @SerializedName("dni") var dni: String? = "",
    @SerializedName("nombres") var nombres: String? = "",
    @SerializedName("apellidos") var apellidos: String? = "",
    @SerializedName("usuarioAnterior") var usuarioAnterior: String? = "",
    @SerializedName("usuarioDominio") var usuarioDominio: String? = "",
    @SerializedName("equipo") var equipo: String? = "",
    @SerializedName("lote") var lote: String? = "",
    @SerializedName("host") var host: String? = "",
    @SerializedName("marca") var marca: String? = "",
    @SerializedName("modelo") var modelo: String? = "",
    @SerializedName("serie") var serie: String? = "",
    @SerializedName("procesador") var procesador: String? = "",
    @SerializedName("memoria") var memoria: String? = "",
    @SerializedName("disco") var disco: String? = "",
    @SerializedName("mac_red") var macRed: String? = "",
    @SerializedName("mac_wifi") var macWifi: String? = "",
    @SerializedName("estado") var estado: String? = "",
    @SerializedName("precio_lote") var precioLote: String? = "",
    @SerializedName("lic_office") var licOffice: String? = "",
    @SerializedName("precio_lic_office") var precioLicOffice: String? = "",
    @SerializedName("lic_sap") var licSap: String? = "",
    @SerializedName("precio_lic_sap") var precioLicSap: String? = "",
    @SerializedName("lic_antivirus") var licAntivirus: String? = "",
    @SerializedName("precio_lic_antivirus") var precioLicAntivirus: String? = "",
    @SerializedName("obs") var obs: String? = ""
)
