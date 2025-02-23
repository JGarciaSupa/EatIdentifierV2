package com.lobito.eatidentifiervip.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.lobito.eatidentifiervip.data.local.model.SessionEntity
import com.lobito.eatidentifiervip.data.local.model.UserEntity

@Dao
interface UserDao : BaseDao<UserEntity> {

    @Query("SELECT * FROM UserEntity ")
    suspend fun getSessionOpen(): UserEntity


}