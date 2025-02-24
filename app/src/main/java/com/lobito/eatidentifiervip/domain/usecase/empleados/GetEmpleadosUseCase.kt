package com.lobito.eatidentifiervip.domain.usecase.empleados


import com.lobito.eatidentifiervip.domain.model.Empleado
import com.lobito.eatidentifiervip.domain.repository.EmpleadoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetEmpleadosUseCase (
    private val repository: EmpleadoRepository
) {
    suspend operator fun invoke(): Flow<List<Empleado>> = flow {
        val empleadoFromApi = repository.getEmpleadoFromApi()
        if (empleadoFromApi.isNotEmpty()) {
            repository.refreshEmpleados(empleadoFromApi)
            emit(empleadoFromApi)
        } else {
            repository.getEmpleadoAll().collect { empresasFromDb ->
                emit(empresasFromDb)
            }
        }
    }
}

