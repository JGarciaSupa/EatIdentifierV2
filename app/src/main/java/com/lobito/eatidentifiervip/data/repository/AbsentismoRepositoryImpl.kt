package com.lobito.eatidentifiervip.data.repository

import com.lobito.eatidentifiervip.data.local.dao.AbsentismoDao
import com.lobito.eatidentifiervip.data.local.model.AbsentismoEntity
import com.lobito.eatidentifiervip.data.remote.model.ResponsePersonalAbsentismoDTO
import com.lobito.eatidentifiervip.data.remote.service.AppService
import com.lobito.eatidentifiervip.domain.repository.AbsentismoRepository

class AbsentismoRepositoryImpl(
    private val appService: AppService,
    private val absentismoDao: AbsentismoDao
) : AbsentismoRepository {

    override suspend fun getAbsentismoFromApi(): ResponsePersonalAbsentismoDTO {
        return appService.getPersonalAbsentismo()
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
