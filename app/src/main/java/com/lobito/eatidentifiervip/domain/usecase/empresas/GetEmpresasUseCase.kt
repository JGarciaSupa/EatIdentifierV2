package com.lobito.eatidentifiervip.domain.usecase.empresas


import com.lobito.eatidentifiervip.domain.model.Empresa
import com.lobito.eatidentifiervip.domain.repository.EmpresaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetEmpresasUseCase (
    private val repository: EmpresaRepository
) {
    suspend operator fun invoke(): Flow<List<Empresa>> = flow {
        val empresaFromApi = repository.getEmpresasFromApi()
        if (empresaFromApi.isNotEmpty()) {
            repository.clearEmpresas()
            repository.insertEmpresas(empresaFromApi)
            emit(empresaFromApi)
        } else {
            emit(emptyList())
        }
    }
}
