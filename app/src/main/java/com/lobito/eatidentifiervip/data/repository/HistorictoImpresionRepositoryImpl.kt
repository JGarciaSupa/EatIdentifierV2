package com.lobito.eatidentifiervip.data.repository


import com.lobito.eatidentifiervip.data.local.dao.HistoricoImpresionDao
import com.lobito.eatidentifiervip.domain.model.HistoricoImpresion
import com.lobito.eatidentifiervip.domain.model.toDomain
import com.lobito.eatidentifiervip.domain.model.toEntity
import com.lobito.eatidentifiervip.domain.repository.HistoricoImpresionRepository

class HistorictoImpresionRepositoryImpl(
    private val historicoImpresionDao: HistoricoImpresionDao
    ) : HistoricoImpresionRepository {

    override suspend fun insertHistoricoImpresion(historicoImpresion: HistoricoImpresion) {
         historicoImpresionDao.insert(historicoImpresion.toEntity())
    }

    override suspend fun getHistoricoImpresion(): List<HistoricoImpresion> {
        return historicoImpresionDao.getAll().map { it.toDomain() }
    }

    override suspend fun getHistoricoByEmpleado(idEmpleado: String, fecha: String, tipoComida: String): HistoricoImpresion? {
        return historicoImpresionDao.getHistoricoByEmpleado(idEmpleado, fecha, tipoComida)?.toDomain()
    }


}