package com.lobito.appbusesvip.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
interface BaseDao <T>{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplace(entity: T): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(entities: List<T>): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllOrReplace(entities: List<T>): LongArray

    @Update
    fun update(vararg entity: T): Int

    @Delete
    fun delete(vararg entity: T): Int

}