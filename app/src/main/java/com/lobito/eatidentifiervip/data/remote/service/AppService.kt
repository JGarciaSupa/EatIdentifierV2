package com.lobito.eatidentifiervip.data.remote.service

import android.content.Context
import com.lobito.eatidentifiervip.data.remote.apis.IdentificadorApi
import com.lobito.eatidentifiervip.data.remote.apis.EatIdentifierApi
import com.lobito.eatidentifiervip.data.remote.model.RequestSessionDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseDniEstadoDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseEmpleadoDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseEmpresasDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseGenericDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseMenuDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseSessionDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppService(
    private val context: Context,
    private val identificadorApi: IdentificadorApi,
    private val eatIdentifierApi: EatIdentifierApi,
) {
    //////////////////////// EAT IDENTIFIER /////////////////////////////////////
    suspend fun getMenu(): ResponseGenericDTO<List<ResponseMenuDTO>> {
        return withContext(Dispatchers.IO){
            val response = eatIdentifierApi.getMenu()
            response.body() ?: ResponseGenericDTO(data = emptyList())
        }
    }

    suspend fun getEmpresa(): ResponseGenericDTO<List<ResponseEmpresasDTO>> {
        return withContext(Dispatchers.IO){
            val response = eatIdentifierApi.getEmpresa()
            response.body() ?: ResponseGenericDTO(data = emptyList())
        }
    }

    suspend fun getEmpleadoFromApi(): ResponseGenericDTO<List<ResponseEmpleadoDTO>> {
        return withContext(Dispatchers.IO){
            val response = eatIdentifierApi.getEmpleado()
            response.body() ?: ResponseGenericDTO(data = emptyList())
        }
    }

    suspend fun postLogin(request : RequestSessionDTO): ResponseGenericDTO<ResponseSessionDTO> {
        return withContext(Dispatchers.IO){
            val response = eatIdentifierApi.postLogin(request = request)
            response.body() ?: ResponseGenericDTO(data = null)
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    suspend fun getIdentificadorFromApi(dni: String): ResponseDniEstadoDTO {
        return withContext(Dispatchers.IO){
            val response = identificadorApi.getNameEstadoByDNI(dni)
            response.body() ?: ResponseDniEstadoDTO(data = null , success = false)
        }
    }


}