package com.lobito.eatidentifiervip.domain.usecase.dataInit

import com.lobito.eatidentifiervip.data.remote.model.ResponseDniEstadoDTO
import com.lobito.eatidentifiervip.domain.repository.IdentificadorRepository

class GetIdentificadorUseCase(private val identificadorRepository: IdentificadorRepository) {
    suspend operator fun invoke(dni : String): ResponseDniEstadoDTO {
        val response = identificadorRepository.getIdentificadorFromApi(dni)
        return response
    }
}

