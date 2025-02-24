package com.lobito.eatidentifiervip.data.remote.service

import android.content.Context
import com.lobito.eatidentifiervip.data.remote.apis.EmployeeApi
import com.lobito.eatidentifiervip.data.remote.apis.IdentificadorApi
import com.lobito.eatidentifiervip.data.remote.apis.InventoryApi
import com.lobito.eatidentifiervip.data.remote.apis.BusesApi
import com.lobito.eatidentifiervip.data.remote.apis.EatIdentifierApi
import com.lobito.eatidentifiervip.data.remote.apis.SecurityApi
import com.lobito.eatidentifiervip.data.remote.model.RequestSessionDTO
import com.lobito.eatidentifiervip.data.remote.model.RequestTokenDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseDniEstadoDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseEmpleadoDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseEmpresasDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseGenericDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseIventarioDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseMenuDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponsePersonalAbsentismoDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseSessionDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseTokenSecurityDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppService(
    private val context: Context,
    private val busesApi: BusesApi,
    private val securityApi: SecurityApi,
    private val employeeApi: EmployeeApi,
    private val identificadorApi: IdentificadorApi,
    private val inventoryApi : InventoryApi,
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

    suspend fun getTokenSecurity(request : RequestTokenDTO): ResponseTokenSecurityDTO {
        return withContext(Dispatchers.IO){
            val response = securityApi.getToken(request = request)
            response.body() ?: ResponseTokenSecurityDTO(message = "Respuesta vacía", success = "false")
        }
    }

    suspend fun getTokenEmployee(request : RequestTokenDTO): String {
        return withContext(Dispatchers.IO){
            val response = employeeApi.getToken(request = request)
            response.body() ?: ""
        }
    }

    suspend fun getTokenIventory(request : RequestTokenDTO): String {
        return withContext(Dispatchers.IO){
            val response = inventoryApi.getToken(request = request)
            response.body() ?: ""
        }
    }

    suspend fun getPersonalAbsentismo(): ResponsePersonalAbsentismoDTO {
        return withContext(Dispatchers.IO){
            val response = employeeApi.getPersonalAbsentismo()
            response.body() ?: ResponsePersonalAbsentismoDTO(personal = emptyList())
        }
    }

    suspend fun getInventoryAll(): List<ResponseIventarioDTO> {
        return withContext(Dispatchers.IO){
            val response = inventoryApi.GetInventarioAll()
            response.body() ?: emptyList()
        }
    }

    suspend fun getIdentificadorFromApi(dni: String): ResponseDniEstadoDTO {
        return withContext(Dispatchers.IO){
            val response = identificadorApi.getNameEstadoByDNI(dni)
            response.body() ?: ResponseDniEstadoDTO(data = null , success = false)
        }
    }

    suspend fun getTokenBuses(request: RequestTokenDTO): ResponseTokenSecurityDTO {
        return withContext(Dispatchers.IO){
            val response = busesApi.getToken(request = request)
            response.body() ?: ResponseTokenSecurityDTO(message = "Respuesta vacía", success = "false")
        }
    }
}