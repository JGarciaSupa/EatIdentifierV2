package com.lobito.eatidentifiervip.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.lobito.eatidentifiervip.data.local.model.UserEntity

@Dao
interface UserDao : BaseDao<UserEntity> {

    @Query("SELECT * FROM UserEntity WHERE username = :username LIMIT 1")
    suspend fun getUserByUsername(username: String): UserEntity?

    @Query("UPDATE UserEntity SET flag = :flag WHERE id = :userId")
    suspend fun updateFlagById(userId: Long, flag: Int)

    @Query("SELECT * FROM UserEntity WHERE flag = 0 LIMIT 1") // Buscar usuario con flag 0 (sesión pendiente)
    suspend fun getLoggedInUser(): UserEntity?
}