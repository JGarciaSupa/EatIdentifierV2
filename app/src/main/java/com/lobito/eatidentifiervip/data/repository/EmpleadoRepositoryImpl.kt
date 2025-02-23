package com.lobito.eatidentifiervip.data.repository

import com.lobito.eatidentifiervip.data.remote.model.ResponseEmpleadoDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseGenericDTO
import com.lobito.eatidentifiervip.data.remote.service.AppService
import com.lobito.eatidentifiervip.domain.repository.EmpleadoRepository

class EmpleadoRepositoryImpl(private val apbusesService : AppService) : EmpleadoRepository {

    override suspend fun getEmpleadoFromApi(): ResponseGenericDTO<List<ResponseEmpleadoDTO>>  {
        return apbusesService.getEmpleado()
    }


}