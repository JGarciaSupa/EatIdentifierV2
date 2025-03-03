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
        EmpresaEntity::class,
        SessionEntity::class,
        EmpleadoEntity::class,
        ConfiguracionLocalEntity::class,
        ConfiguracionGlobalEntity::class,
    ],
    version = 7,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun empresaDao(): EmpresaDao
    abstract fun sessionDao(): SessionDao
    abstract fun empleadoDao(): EmpleadoDao
    abstract fun configuracionLocalDao(): ConfiguracionLocalDao
    abstract fun configuracionGlobalDao(): ConfiguracionGlobalDao
}
