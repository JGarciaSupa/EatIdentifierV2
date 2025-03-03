package com.lobito.eatidentifiervip.domain.usecase.confLocal

import com.lobito.eatidentifiervip.data.remote.model.ResponseDniEstadoDTO
import com.lobito.eatidentifiervip.domain.repository.ConfiguracionGlobalRepository
import com.lobito.eatidentifiervip.domain.repository.ConfiguracionLocalRepository
import com.lobito.eatidentifiervip.domain.repository.IdentificadorRepository

class ConfiguracionLocalUseCase(private val configuracionLocalRepository: ConfiguracionLocalRepository) {
    suspend operator fun invoke() {

    }
}

