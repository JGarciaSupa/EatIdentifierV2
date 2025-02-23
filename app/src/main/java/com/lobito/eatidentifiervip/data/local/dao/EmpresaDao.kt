package com.lobito.eatidentifiervip.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.lobito.eatidentifiervip.data.local.model.EmpresaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EmpresaDao : BaseDao<EmpresaEntity> {

    @Query("SELECT * FROM EmpresaEntity")
    fun getAllEmpresas(): Flow<List<EmpresaEntity>>

    @Query("DELETE FROM EmpresaEntity")
    suspend fun deleteAllEmpresas()

}