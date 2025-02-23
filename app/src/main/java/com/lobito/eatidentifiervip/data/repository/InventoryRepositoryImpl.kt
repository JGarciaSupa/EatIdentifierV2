package com.lobito.eatidentifiervip.data.repository

import com.lobito.eatidentifiervip.data.local.dao.InventoryDao
import com.lobito.eatidentifiervip.data.local.model.InventoryEntity
import com.lobito.eatidentifiervip.data.remote.model.ResponseIventarioDTO
import com.lobito.eatidentifiervip.data.remote.service.AppService
import com.lobito.eatidentifiervip.domain.repository.InventoryRepository

class InventoryRepositoryImpl(
    private val appService: AppService,
    private val inventoryDao: InventoryDao
    ) : InventoryRepository {
    override suspend fun getInventoryFromApi(): List<ResponseIventarioDTO> {
        return appService.getInventoryAll()
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