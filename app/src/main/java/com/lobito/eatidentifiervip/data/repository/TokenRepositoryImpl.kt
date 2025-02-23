package com.lobito.eatidentifiervip.data.repository

import com.lobito.eatidentifiervip.data.remote.model.RequestTokenDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseTokenSecurityDTO
import com.lobito.eatidentifiervip.data.remote.service.AppService
import com.lobito.eatidentifiervip.domain.repository.TokenRepository

class TokenRepositoryImpl(private val apbusesService : AppService) : TokenRepository {

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