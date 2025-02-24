package com.lobito.eatidentifiervip.domain.usecase.empleados


import com.lobito.eatidentifiervip.domain.model.Empleado
import com.lobito.eatidentifiervip.domain.repository.EmpleadoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetEmpleadoByCuiUseCase (
    private val repository: EmpleadoRepository
) {
    suspend operator fun invoke(cui : String): Empleado {
        return repository.findEmpleadoByCui(cui)
    }
}

