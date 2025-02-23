package com.lobito.appbusesvip.data.repository

import com.lobito.appbusesvip.data.local.dao.AbsentismoDao
import com.lobito.appbusesvip.data.local.model.AbsentismoEntity
import com.lobito.appbusesvip.data.remote.model.ResponsePersonalAbsentismoDTO
import com.lobito.appbusesvip.data.remote.service.AppbusesService
import com.lobito.appbusesvip.domain.repository.AbsentismoRepository

class AbsentismoRepositoryImpl(
    private val appbusesService: AppbusesService,
    private val absentismoDao: AbsentismoDao
) : AbsentismoRepository {

    override suspend fun getAbsentismoFromApi(): ResponsePersonalAbsentismoDTO {
        return appbusesService.getPersonalAbsentismo()
    }

    override suspend fun getAbsentismoFromDb(): List<AbsentismoEntity> {
        return absentismoDao.getAllAbsentismo()
    }

    override suspend fun insertAbsentismo(list: List<AbsentismoEntity>) {
        absentismoDao.insertAll(list)
    }

    override suspend fun deleteAbsentismoByDni(dnis: List<String>) {
        absentismoDao.deleteByDni(dnis)
    }
}
