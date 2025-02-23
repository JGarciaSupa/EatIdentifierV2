package com.lobito.eatidentifiervip.domain.repository

import com.lobito.eatidentifiervip.data.remote.model.ResponseDniEstadoDTO

interface IdentificadorRepository {
    suspend fun getIdentificadorFromApi(dni : String): ResponseDniEstadoDTO
}
