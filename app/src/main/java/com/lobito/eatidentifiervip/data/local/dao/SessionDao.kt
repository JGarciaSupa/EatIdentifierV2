package com.lobito.eatidentifiervip.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.lobito.eatidentifiervip.data.local.model.SessionEntity
import com.lobito.eatidentifiervip.data.local.model.UserEntity

@Dao
interface SessionDao : BaseDao<SessionEntity> {

    @Query("SELECT * FROM SessionEntity WHERE state = ${SessionEntity.OPEN}")
    suspend fun getSessionOpen(): SessionEntity?

    @Query("UPDATE SessionEntity SET state = ${SessionEntity.TRUNK} WHERE state = 0")
    suspend fun trunkUsersPending()

    @Query("UPDATE SessionEntity SET state = ${SessionEntity.CLOSE} WHERE idUsuario = :idUser")
    suspend fun logoutSession(idUser: String)

}