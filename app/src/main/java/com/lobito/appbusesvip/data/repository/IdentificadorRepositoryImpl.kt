package com.lobito.appbusesvip.data.repository

import com.lobito.appbusesvip.data.remote.model.ResponseDniEstadoDTO
import com.lobito.appbusesvip.data.remote.service.AppbusesService
import com.lobito.appbusesvip.domain.repository.IdentificadorRepository

class IdentificadorRepositoryImpl (
    private val appbusesService: AppbusesService,
) :  IdentificadorRepository {
    override suspend fun getIdentificadorFromApi(dni : String) : ResponseDniEstadoDTO {
        return appbusesService.getIdentificadorFromApi(dni)
    }
}