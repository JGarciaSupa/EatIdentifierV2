package com.lobito.appbusesvip.data.remote.apis

import com.lobito.appbusesvip.data.remote.model.ResponseDniEstadoDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IdentificadorApi {
    @GET("/search/dni/{dniUser}/83e5206a-4a21-4aa4-b680-8653dc811e51")
    suspend fun getNameEstadoByDNI(@Path("dniUser") dniUser: String): Response<ResponseDniEstadoDTO>
}