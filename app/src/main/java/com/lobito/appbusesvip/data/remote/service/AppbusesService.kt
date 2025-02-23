package com.lobito.appbusesvip.data.remote.service

import android.content.Context
import com.lobito.appbusesvip.data.remote.apis.EmployeeApi
import com.lobito.appbusesvip.data.remote.apis.IdentificadorApi
import com.lobito.appbusesvip.data.remote.apis.InventoryApi
import com.lobito.appbusesvip.data.remote.apis.BusesApi
import com.lobito.appbusesvip.data.remote.apis.SecurityApi
import com.lobito.appbusesvip.data.remote.model.RequestTokenDTO
import com.lobito.appbusesvip.data.remote.model.ResponseDniEstadoDTO
import com.lobito.appbusesvip.data.remote.model.ResponseIventarioDTO
import com.lobito.appbusesvip.data.remote.model.ResponsePersonalAbsentismoDTO
import com.lobito.appbusesvip.data.remote.model.ResponseTokenSecurityDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppbusesService(
    private val context: Context,
    private val busesApi: BusesApi,
    private val securityApi: SecurityApi,
    private val employeeApi: EmployeeApi,
    private val identificadorApi: IdentificadorApi,
    private val inventoryApi : InventoryApi,
) {

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