package com.lobito.eatidentifiervip.domain.repository

import com.lobito.eatidentifiervip.data.remote.model.RequestTokenDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseEmpleadoDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseEmpresasDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseGenericDTO
import com.lobito.eatidentifiervip.data.remote.model.ResponseTokenSecurityDTO

interface EmpleadoRepository {
    suspend fun getEmpleadoFromApi(): ResponseGenericDTO<List<ResponseEmpleadoDTO>>
}
