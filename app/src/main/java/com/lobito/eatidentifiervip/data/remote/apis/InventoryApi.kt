package com.lobito.eatidentifiervip.data.remote.apis

import com.lobito.eatidentifiervip.data.remote.model.RequestTokenDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseIventarioDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface InventoryApi {
    @POST("/api/api/Auth/login")
    suspend fun getToken(@Body request: RequestTokenDTO): Response<String>

    @GET("/api/Inventario")
    suspend fun GetInventarioAll(): Response<List<ResponseIventarioDTO>>
}