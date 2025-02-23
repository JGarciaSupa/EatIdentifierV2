package com.lobito.eatidentifiervip.domain.repository

import com.lobito.eatidentifiervip.data.local.model.AbsentismoEntity
import com.lobito.eatidentifiervip.data.remote.model.ResponsePersonalAbsentismoDTO

interface AbsentismoRepository {
    suspend fun getAbsentismoFromApi(): ResponsePersonalAbsentismoDTO
    suspend fun getAbsentismoFromDb(): List<AbsentismoEntity>
    suspend fun insertAbsentismo(list: List<AbsentismoEntity>)
    suspend fun deleteAbsentismoByDni(dnis: List<String>)
}
