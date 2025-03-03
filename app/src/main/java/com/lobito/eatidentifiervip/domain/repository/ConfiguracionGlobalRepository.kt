package com.lobito.eatidentifiervip.domain.repository

import com.lobito.eatidentifiervip.data.remote.model.RequestSessionDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseSessionDTO
import com.lobito.eatidentifiervip.domain.model.Session

interface ConfiguracionGlobalRepository {
    suspend fun trunkUsersPending()
}
