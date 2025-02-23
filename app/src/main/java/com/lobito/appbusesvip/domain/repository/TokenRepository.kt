package com.lobito.appbusesvip.domain.repository

import com.lobito.appbusesvip.data.remote.model.RequestTokenDTO
import com.lobito.appbusesvip.data.remote.model.ResponseTokenSecurityDTO
import com.lobito.appbusesvip.domain.model.User

interface TokenRepository {
    suspend fun getTokenSecurity(request : RequestTokenDTO) : ResponseTokenSecurityDTO
    suspend fun getTokenEmployee(request : RequestTokenDTO) : String
    suspend fun getTokenIventory(request : RequestTokenDTO) : String
    suspend fun getTokenBuses(request: RequestTokenDTO): ResponseTokenSecurityDTO
}
