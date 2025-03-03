package com.lobito.eatidentifiervip.data.repository

import com.lobito.eatidentifiervip.data.local.dao.ConfiguracionGlobalDao
import com.lobito.eatidentifiervip.data.remote.model.ResponseDniEstadoDTO
import com.lobito.eatidentifiervip.data.remote.service.AppService
import com.lobito.eatidentifiervip.domain.repository.ConfiguracionGlobalRepository
import com.lobito.eatidentifiervip.domain.repository.ConfiguracionLocalRepository
import com.lobito.eatidentifiervip.domain.repository.IdentificadorRepository

class ConfiguracionGlobalRepositoryImpl (
    private val configuracionGlobalDao: ConfiguracionGlobalDao,
) :  ConfiguracionGlobalRepository {
    override suspend fun trunkUsersPending() {
        TODO("Not yet implemented")
    }
}