package com.lobito.eatidentifiervip.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.lobito.eatidentifiervip.data.local.model.ConfiguracionLocalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ConfiguracionLocalDao : BaseDao<ConfiguracionLocalEntity> {

    @Query("SELECT * FROM ConfiguracionLocalEntity")
    fun getAll(): Flow<List<ConfiguracionLocalEntity>>

}
