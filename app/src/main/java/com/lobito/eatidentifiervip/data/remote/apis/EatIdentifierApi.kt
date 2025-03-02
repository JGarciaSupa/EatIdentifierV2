package com.lobito.eatidentifiervip.data.remote.apis

import com.lobito.eatidentifiervip.data.remote.model.RequestSessionDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseEmpleadoDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseEmpresasDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseGenericDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseMenuDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseSessionDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface EatIdentifierApi {
    @GET("api/Menu")
    suspend fun getMenu(): Response<ResponseGenericDTO<List<ResponseMenuDTO>>>

    @GET("api/Enterprise")
    suspend fun getEmpresa(): Response<ResponseGenericDTO<List<ResponseEmpresasDTO>>>

    @GET("api/Employee")
    suspend fun getEmpleado(): Response<ResponseGenericDTO<List<ResponseEmpleadoDTO>>>

    @POST("api/User/Login")
    suspend fun postLogin(@Body request : RequestSessionDTO): Response<ResponseGenericDTO<ResponseSessionDTO>>

}