package com.lobito.appbusesvip.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lobito.appbusesvip.data.local.converter.TimeConverter
import com.lobito.appbusesvip.data.local.dao.AbsentismoDao
import com.lobito.appbusesvip.data.local.dao.InventoryDao
import com.lobito.appbusesvip.data.local.dao.UserDao
import com.lobito.appbusesvip.data.local.model.AbsentismoEntity
import com.lobito.appbusesvip.data.local.model.InventoryEntity
import com.lobito.appbusesvip.data.local.model.UserEntity

@TypeConverters(TimeConverter::class)
@Database(
    entities = [
        UserEntity::class,
        AbsentismoEntity::class,
        InventoryEntity::class,
    ],
    version = 7,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun absentismoDao(): AbsentismoDao
    abstract fun inventoryDao(): InventoryDao
}
