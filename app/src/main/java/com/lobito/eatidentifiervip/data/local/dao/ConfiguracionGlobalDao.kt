package com.lobito.eatidentifiervip.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.lobito.eatidentifiervip.data.local.model.ConfiguracionGlobalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ConfiguracionGlobalDao : BaseDao<ConfiguracionGlobalEntity> {

    @Query("SELECT * FROM ConfiguracionGlobalEntity")
    fun getAll(): Flow<List<ConfiguracionGlobalEntity>>

}
