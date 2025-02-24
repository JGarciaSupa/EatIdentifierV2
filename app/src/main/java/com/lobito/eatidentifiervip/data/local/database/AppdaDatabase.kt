package com.lobito.eatidentifiervip.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lobito.eatidentifiervip.data.local.converter.TimeConverter
import com.lobito.eatidentifiervip.data.local.dao.*
import com.lobito.eatidentifiervip.data.local.model.*

@TypeConverters(TimeConverter::class)
@Database(
    entities = [
        UserEntity::class,
        AbsentismoEntity::class,
        InventoryEntity::class,
        EmpresaEntity::class,
        SessionEntity::class,
        EmpleadoEntity::class
    ],
    version = 5,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun absentismoDao(): AbsentismoDao
    abstract fun inventoryDao(): InventoryDao
    abstract fun empresaDao(): EmpresaDao
    abstract fun sessionDao(): SessionDao
    abstract fun empleadoDao(): EmpleadoDao
}
