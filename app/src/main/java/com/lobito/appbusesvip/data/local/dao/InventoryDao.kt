package com.lobito.appbusesvip.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.lobito.appbusesvip.data.local.model.InventoryEntity

@Dao
interface InventoryDao : BaseDao<InventoryEntity>{

    @Query("SELECT * FROM InventoryEntity")
    suspend fun getAll(): List<InventoryEntity>

    @Query("DELETE FROM InventoryEntity WHERE dni IN (:dnis)")
    suspend fun deleteByDni(dnis: List<String>)

}

