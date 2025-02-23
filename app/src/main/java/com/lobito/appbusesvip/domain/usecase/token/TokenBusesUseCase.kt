package com.lobito.appbusesvip.domain.usecase.token

import com.lobito.appbusesvip.data.remote.model.RequestTokenDTO
import com.lobito.appbusesvip.data.remote.model.ResponseTokenSecurityDTO
import com.lobito.appbusesvip.domain.repository.TokenRepository

class TokenBusesUseCase (private val tokenRepository: TokenRepository) {
    suspend operator fun invoke(request: RequestTokenDTO): ResponseTokenSecurityDTO {
        return tokenRepository.getTokenBuses(request)
    }
}