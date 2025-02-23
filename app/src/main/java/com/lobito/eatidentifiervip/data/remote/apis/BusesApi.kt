package com.lobito.eatidentifiervip.data.remote.apis

import com.lobito.eatidentifiervip.data.remote.model.RequestRegistroBusDTO
import com.lobito.eatidentifiervip.data.remote.model.RequestTokenDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseGenericDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseTokenSecurityDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface BusesApi {
    @POST("/api/token")
    suspend fun getToken(@Body request: RequestTokenDTO): Response<ResponseTokenSecurityDTO>

    @POST("/api/RegistroBus/InsertRegistroBus")
    suspend fun registroBusInsert(@Body registroBus: RequestRegistroBusDTO): Response<ResponseGenericDTO<Int>>

//    @POST("/api/RegistroIncidente/InsertRegistroIncidente")
//    suspend fun registroIncidenteInsert(@Body registroIncidente: RegistroIncidente): Call<JsonInsertResult>

}