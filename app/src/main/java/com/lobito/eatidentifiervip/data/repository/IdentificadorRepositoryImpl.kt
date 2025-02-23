package com.lobito.eatidentifiervip.data.repository

import com.lobito.eatidentifiervip.data.remote.model.ResponseDniEstadoDTO
import com.lobito.eatidentifiervip.data.remote.service.AppService
import com.lobito.eatidentifiervip.domain.repository.IdentificadorRepository

class IdentificadorRepositoryImpl (
    private val appService: AppService,
) :  IdentificadorRepository {
    override suspend fun getIdentificadorFromApi(dni : String) : ResponseDniEstadoDTO {
        return appService.getIdentificadorFromApi(dni)
    }
}