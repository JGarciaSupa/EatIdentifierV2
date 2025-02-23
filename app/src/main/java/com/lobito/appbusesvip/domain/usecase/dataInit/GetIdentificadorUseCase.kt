package com.lobito.appbusesvip.domain.usecase.dataInit

import com.lobito.appbusesvip.data.remote.model.ResponseDniEstadoDTO
import com.lobito.appbusesvip.domain.repository.IdentificadorRepository

class GetIdentificadorUseCase(private val identificadorRepository: IdentificadorRepository) {
    suspend operator fun invoke(dni : String): ResponseDniEstadoDTO {
        val response = identificadorRepository.getIdentificadorFromApi(dni)
        return response
    }
}

