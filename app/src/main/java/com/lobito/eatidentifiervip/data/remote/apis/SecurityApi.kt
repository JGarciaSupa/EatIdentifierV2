package com.lobito.eatidentifiervip.data.remote.apis

import com.lobito.eatidentifiervip.data.remote.model.RequestLogDTO
import com.lobito.eatidentifiervip.data.remote.model.RequestLoginDTO
import com.lobito.eatidentifiervip.data.remote.model.RequestTokenDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseAutenticacionUsuarioDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseGenericDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseLogDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseTokenSecurityDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SecurityApi {
    @POST("/api/token")
    suspend fun getToken(@Body request: RequestTokenDTO): Response<ResponseTokenSecurityDTO>

    @POST("/api/UsuarioAutentificacion/Autentificacion")
    suspend fun login(@Body login: RequestLoginDTO): Response<ResponseGenericDTO<ResponseAutenticacionUsuarioDTO>>

    @POST("/api/log/registrarLogs")
    suspend fun registrarLogs(@Body logs: List<RequestLogDTO>): Response<ResponseLogDTO>
}

