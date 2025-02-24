package com.lobito.eatidentifiervip.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.lobito.eatidentifiervip.data.local.model.EmpleadoEntity
import com.lobito.eatidentifiervip.data.local.model.SessionEntity
import com.lobito.eatidentifiervip.data.local.model.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EmpleadoDao : BaseDao<EmpleadoEntity> {

    @Query("SELECT * FROM EmpleadoEntity")
    fun getAllEmpleados(): Flow<List<EmpleadoEntity>>

    @Query("SELECT * FROM EmpleadoEntity WHERE cui = :cui")
    suspend fun getEmpleadoByCui(cui: String): EmpleadoEntity

    @Query("DELETE FROM EmpleadoEntity")
    suspend fun clearEmpleados()

    @Transaction
    suspend fun refreshEmpleados(empleados: List<EmpleadoEntity>) {
        clearEmpleados()
        insertAllOrReplace(empleados)
    }
}
