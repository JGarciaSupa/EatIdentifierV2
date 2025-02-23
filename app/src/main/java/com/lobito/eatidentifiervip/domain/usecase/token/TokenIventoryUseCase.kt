package com.lobito.eatidentifiervip.domain.usecase.token

import com.lobito.eatidentifiervip.data.remote.model.RequestTokenDTO
import com.lobito.eatidentifiervip.domain.repository.TokenRepository

class TokenInventoryUseCase (private val tokenRepository: TokenRepository) {
    suspend operator fun invoke(request: RequestTokenDTO): String {
        return tokenRepository.getTokenIventory(request)
    }
}