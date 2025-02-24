package com.lobito.eatidentifiervip.domain.usecase.empleados


import com.lobito.eatidentifiervip.data.common.Resource
import com.lobito.eatidentifiervip.domain.model.Empleado
import com.lobito.eatidentifiervip.domain.repository.EmpleadoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class InsertEmpleadoUseCase (
    private val repository: EmpleadoRepository
) {
    suspend operator fun invoke(list : List<Empleado>) {
        repository.refreshEmpleados(list)
    }
}

