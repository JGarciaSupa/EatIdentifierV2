package com.lobito.appbusesvip.domain.repository

import com.lobito.appbusesvip.data.local.model.AbsentismoEntity
import com.lobito.appbusesvip.data.local.model.InventoryEntity
import com.lobito.appbusesvip.data.remote.model.ResponseIventarioDTO
import com.lobito.appbusesvip.data.remote.model.ResponsePersonalAbsentismoDTO

interface InventoryRepository {
    suspend fun getInventoryFromApi(): List<ResponseIventarioDTO>
    suspend fun getInventoryFromDb(): List<InventoryEntity>
    suspend fun insertInventory(list: List<InventoryEntity>)
    suspend fun deleteInventoryByDni(dnis: List<String>)
}
