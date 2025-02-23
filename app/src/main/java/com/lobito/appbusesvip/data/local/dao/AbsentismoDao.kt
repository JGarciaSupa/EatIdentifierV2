package com.lobito.appbusesvip.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.lobito.appbusesvip.data.local.model.AbsentismoEntity

@Dao
interface AbsentismoDao : BaseDao<AbsentismoEntity>{


    @Query("SELECT * FROM AbsentismoEntity")
    suspend fun getAllAbsentismo(): List<AbsentismoEntity>


    @Query("DELETE FROM AbsentismoEntity WHERE dni IN (:dnis)")
    suspend fun deleteByDni(dnis: List<String>)

}

