package com.lobito.appbusesvip.data.repository

import com.lobito.appbusesvip.data.remote.model.RequestTokenDTO
import com.lobito.appbusesvip.data.remote.model.ResponseTokenSecurityDTO
import com.lobito.appbusesvip.data.remote.service.AppbusesService
import com.lobito.appbusesvip.domain.repository.TokenRepository

class TokenRepositoryImpl(private val apbusesService : AppbusesService) : TokenRepository {

    override suspend fun getTokenSecurity(request: RequestTokenDTO) : ResponseTokenSecurityDTO {
        return apbusesService.getTokenSecurity(request = request)
    }

    override suspend fun getTokenEmployee(request: RequestTokenDTO): String {
        return apbusesService.getTokenEmployee(request = request)
    }

    override suspend fun getTokenIventory(request: RequestTokenDTO): String {
        return apbusesService.getTokenIventory(request = request)
    }

    override suspend fun getTokenBuses(request: RequestTokenDTO): ResponseTokenSecurityDTO {
        return apbusesService.getTokenBuses(request = request)
    }
}