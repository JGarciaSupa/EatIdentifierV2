package com.lobito.eatidentifiervip.domain.usecase.token

import com.lobito.eatidentifiervip.data.remote.model.RequestTokenDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseTokenSecurityDTO
import com.lobito.eatidentifiervip.domain.repository.TokenRepository

class TokenBusesUseCase (private val tokenRepository: TokenRepository) {
    suspend operator fun invoke(request: RequestTokenDTO): ResponseTokenSecurityDTO {
        return tokenRepository.getTokenBuses(request)
    }
}