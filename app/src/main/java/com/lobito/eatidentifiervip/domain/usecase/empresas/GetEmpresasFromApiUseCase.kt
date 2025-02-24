package com.lobito.eatidentifiervip.domain.usecase.empresas


import com.lobito.eatidentifiervip.data.common.Resource
import com.lobito.eatidentifiervip.domain.model.Empresa
import com.lobito.eatidentifiervip.domain.model.toDomain
import com.lobito.eatidentifiervip.domain.repository.EmpresaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class GetEmpresasFromApiUseCase(
    private val repository: EmpresaRepository
) {
    suspend operator fun invoke(): Resource<List<Empresa>> {
        return try {
            val empresaFromApi = repository.getEmpresasFromApi()
            Resource.Success(empresaFromApi)
        } catch (e: Exception) {
            Resource.Error("No Obtuvo Empresas", e)
        }
    }
}