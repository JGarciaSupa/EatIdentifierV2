package com.lobito.appbusesvip.data.repository

import com.lobito.appbusesvip.data.local.dao.InventoryDao
import com.lobito.appbusesvip.data.local.model.InventoryEntity
import com.lobito.appbusesvip.data.remote.model.ResponseIventarioDTO
import com.lobito.appbusesvip.data.remote.service.AppbusesService
import com.lobito.appbusesvip.domain.repository.InventoryRepository

class InventoryRepositoryImpl(
    private val appbusesService: AppbusesService,
    private val inventoryDao: InventoryDao
    ) : InventoryRepository {
    override suspend fun getInventoryFromApi(): List<ResponseIventarioDTO> {
        return appbusesService.getInventoryAll()
    }

    override suspend fun getInventoryFromDb(): List<InventoryEntity> {
        return inventoryDao.getAll()
    }

    override suspend fun insertInventory(list: List<InventoryEntity>) {
         inventoryDao.insertAll(list)
    }

    override suspend fun deleteInventoryByDni(dnis: List<String>) {
        inventoryDao.deleteByDni(dnis)
    }


}