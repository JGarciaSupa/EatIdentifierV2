package com.lobito.eatidentifiervip.domain.repository

import com.lobito.eatidentifiervip.domain.model.Empresa
import kotlinx.coroutines.flow.Flow

interface EmpresaRepository {
    suspend fun getEmpresasFromApi(): List<Empresa>
    suspend fun getAllEmpresaFromDatabase(): Flow<List<Empresa>>
    suspend fun insertEmpresas(empresas: List<Empresa>)
    suspend fun clearEmpresas()
}
