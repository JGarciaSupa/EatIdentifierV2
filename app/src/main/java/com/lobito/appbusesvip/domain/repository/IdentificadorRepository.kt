package com.lobito.appbusesvip.domain.repository

import com.lobito.appbusesvip.data.local.model.AbsentismoEntity
import com.lobito.appbusesvip.data.local.model.InventoryEntity
import com.lobito.appbusesvip.data.remote.model.ResponseDniEstadoDTO
import com.lobito.appbusesvip.data.remote.model.ResponseIventarioDTO
import com.lobito.appbusesvip.data.remote.model.ResponsePersonalAbsentismoDTO

interface IdentificadorRepository {
    suspend fun getIdentificadorFromApi(dni : String): ResponseDniEstadoDTO
}
