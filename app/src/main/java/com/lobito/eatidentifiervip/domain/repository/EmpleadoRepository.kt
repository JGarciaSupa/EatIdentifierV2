package com.lobito.eatidentifiervip.domain.repository

import kotlinx.coroutines.flow.Flow
import com.lobito.eatidentifiervip.domain.model.Empleado

interface EmpleadoRepository {
    suspend fun getEmpleadoFromApi(): List<Empleado>
    suspend fun findEmpleadoByCui(cui: String): Empleado
    suspend fun refreshEmpleados(empleados: List<Empleado>)
    suspend fun getEmpleadoAll(): Flow<List<Empleado>>
}
