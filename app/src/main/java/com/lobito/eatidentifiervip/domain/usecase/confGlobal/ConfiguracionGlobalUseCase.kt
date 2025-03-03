package com.lobito.eatidentifiervip.domain.usecase.confGlobal

import com.lobito.eatidentifiervip.data.remote.model.ResponseDniEstadoDTO
import com.lobito.eatidentifiervip.domain.repository.ConfiguracionGlobalRepository
import com.lobito.eatidentifiervip.domain.repository.IdentificadorRepository

class ConfiguracionGlobalUseCase(private val configuracionGlobalRepository: ConfiguracionGlobalRepository) {
    suspend operator fun invoke() {

    }
}

