package com.lobito.appbusesvip.domain.repository

import com.lobito.appbusesvip.data.local.model.AbsentismoEntity
import com.lobito.appbusesvip.data.remote.model.ResponsePersonalAbsentismoDTO

interface AbsentismoRepository {
    suspend fun getAbsentismoFromApi(): ResponsePersonalAbsentismoDTO
    suspend fun getAbsentismoFromDb(): List<AbsentismoEntity>
    suspend fun insertAbsentismo(list: List<AbsentismoEntity>)
    suspend fun deleteAbsentismoByDni(dnis: List<String>)
}
