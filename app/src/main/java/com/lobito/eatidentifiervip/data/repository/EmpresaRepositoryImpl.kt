package com.lobito.eatidentifiervip.data.repository

import com.lobito.eatidentifiervip.data.local.dao.EmpresaDao
import com.lobito.eatidentifiervip.data.local.model.toDatabase
import com.lobito.eatidentifiervip.data.remote.model.ResponseEmpresasDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseGenericDTO
import com.lobito.eatidentifiervip.data.remote.service.AppService
import com.lobito.eatidentifiervip.domain.model.Empresa
import com.lobito.eatidentifiervip.domain.model.toDomain
import com.lobito.eatidentifiervip.domain.repository.EmpresaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EmpresaRepositoryImpl(
    private val apiService: AppService,
    private val empresaDao: EmpresaDao,
    ) : EmpresaRepository {

    override suspend fun getEmpresasFromApi(): List<Empresa> {
        val response: ResponseGenericDTO<List<ResponseEmpresasDTO>> = apiService.getEmpresa()
        return response.data?.map { it.toDomain() } ?: emptyList()
    }

    override suspend fun getAllEmpresaFromDatabase(): Flow<List<Empresa>> {
        return empresaDao.getAllEmpresas().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun insertEmpresas(empresas: List<Empresa>) {
        empresaDao.insertAll(empresas.map { it.toDatabase() })
    }

    override suspend fun clearEmpresas() {
        empresaDao.deleteAllEmpresas()
    }
}
