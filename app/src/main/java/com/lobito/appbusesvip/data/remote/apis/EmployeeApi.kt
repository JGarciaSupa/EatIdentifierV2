package com.lobito.appbusesvip.data.remote.apis

import com.lobito.appbusesvip.data.remote.model.RequestTokenDTO
import com.lobito.appbusesvip.data.remote.model.ResponsePersonalAbsentismoDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface EmployeeApi {
    @POST("/api/login/authenticate")
    suspend fun getToken(@Body request: RequestTokenDTO): Response<String>

    @GET("/api/PersonalAbsentismo")
    suspend fun getPersonalAbsentismo(): Response<ResponsePersonalAbsentismoDTO>
}