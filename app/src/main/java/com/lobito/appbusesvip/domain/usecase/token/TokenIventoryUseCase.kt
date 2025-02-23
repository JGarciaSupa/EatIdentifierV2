package com.lobito.appbusesvip.domain.usecase.token

import com.lobito.appbusesvip.data.remote.model.RequestTokenDTO
import com.lobito.appbusesvip.domain.repository.TokenRepository

class TokenInventoryUseCase (private val tokenRepository: TokenRepository) {
    suspend operator fun invoke(request: RequestTokenDTO): String {
        return tokenRepository.getTokenIventory(request)
    }
}