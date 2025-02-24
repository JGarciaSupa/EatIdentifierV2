package com.lobito.eatidentifiervip.domain.usecase.empresas


import com.lobito.eatidentifiervip.data.common.Resource
import com.lobito.eatidentifiervip.domain.model.Empresa
import com.lobito.eatidentifiervip.domain.model.toDomain
import com.lobito.eatidentifiervip.domain.repository.EmpresaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class InsertEmpresasUseCase(
    private val repository: EmpresaRepository
) {
    suspend operator fun invoke(list : List<Empresa>) {
        repository.insertEmpresas(list)
    }
}