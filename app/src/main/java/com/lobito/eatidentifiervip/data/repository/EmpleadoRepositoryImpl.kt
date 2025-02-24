package com.lobito.eatidentifiervip.data.repository

import com.lobito.eatidentifiervip.data.local.dao.EmpleadoDao
import com.lobito.eatidentifiervip.data.local.model.toDatabase
import com.lobito.eatidentifiervip.data.remote.service.AppService
import com.lobito.eatidentifiervip.domain.model.Empleado
import com.lobito.eatidentifiervip.domain.model.Empresa
import com.lobito.eatidentifiervip.domain.model.toDomain
import com.lobito.eatidentifiervip.domain.repository.EmpleadoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EmpleadoRepositoryImpl(
    private val apbusesService: AppService,
    private val empleadoDao: EmpleadoDao
) : EmpleadoRepository {

    override suspend fun getEmpleadoFromApi(): List<Empleado> {
        return apbusesService.getEmpleadoFromApi().data?.map { it.toDomain() } ?: emptyList()
    }

    override suspend fun findEmpleadoByCui(cui: String): Empleado? {
        return empleadoDao.getEmpleadoByCui(cui)?.toDomain()
    }


    override suspend fun refreshEmpleados(empleados: List<Empleado>) {
        empleadoDao.refreshEmpleados(empleados.map { it.toDatabase() }) // Transacción segura
    }

    override suspend fun getEmpleadoAll(): Flow<List<Empleado>> {
        return empleadoDao.getAllEmpleados().map { entities ->
            entities.map { it.toDomain() }
        }
    }

}