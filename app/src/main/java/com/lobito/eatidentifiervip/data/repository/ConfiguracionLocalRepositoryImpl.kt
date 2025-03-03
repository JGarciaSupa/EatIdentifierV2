package com.lobito.eatidentifiervip.data.repository

import com.lobito.eatidentifiervip.data.local.dao.ConfiguracionLocalDao
import com.lobito.eatidentifiervip.data.remote.model.ResponseDniEstadoDTO
import com.lobito.eatidentifiervip.data.remote.service.AppService
import com.lobito.eatidentifiervip.domain.repository.ConfiguracionLocalRepository
import com.lobito.eatidentifiervip.domain.repository.IdentificadorRepository

class ConfiguracionLocalRepositoryImpl (
    private val configuracionLocalDao: ConfiguracionLocalDao,
) :  ConfiguracionLocalRepository  {
    override suspend fun trunkUsersPending() {
        TODO("Not yet implemented")
    }

}