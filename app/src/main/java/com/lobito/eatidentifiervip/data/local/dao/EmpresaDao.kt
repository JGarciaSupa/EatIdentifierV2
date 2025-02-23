package com.lobito.eatidentifiervip.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.lobito.eatidentifiervip.data.local.model.EmpresaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EmpresaDao : BaseDao<EmpresaEntity> {

    @Query("SELECT * FROM EmpresaEntity ORDER BY id DESC")
    fun getAllEmpresas(): Flow<List<EmpresaEntity>> // Cambiado de suspend a Flow

    @Query("DELETE FROM EmpresaEntity")
    suspend fun deleteAllEmpresas()

}