package com.lobito.eatidentifiervip.domain.repository

import com.lobito.eatidentifiervip.data.remote.model.RequestTokenDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseTokenSecurityDTO

interface TokenRepository {
    suspend fun getTokenSecurity(request : RequestTokenDTO) : ResponseTokenSecurityDTO
    suspend fun getTokenEmployee(request : RequestTokenDTO) : String
    suspend fun getTokenIventory(request : RequestTokenDTO) : String
    suspend fun getTokenBuses(request: RequestTokenDTO): ResponseTokenSecurityDTO
}
