package com.lobito.eatidentifiervip.domain.repository

import com.lobito.eatidentifiervip.data.local.model.InventoryEntity
import com.lobito.eatidentifiervip.data.remote.model.ResponseIventarioDTO

interface InventoryRepository {
    suspend fun getInventoryFromApi(): List<ResponseIventarioDTO>
    suspend fun getInventoryFromDb(): List<InventoryEntity>
    suspend fun insertInventory(list: List<InventoryEntity>)
    suspend fun deleteInventoryByDni(dnis: List<String>)
}
