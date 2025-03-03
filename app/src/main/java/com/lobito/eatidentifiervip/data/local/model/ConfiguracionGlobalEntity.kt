package com.lobito.eatidentifiervip.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.lobito.eatidentifiervip.data.local.converter.TimeConverter
import com.lobito.eatidentifiervip.domain.model.Empleado
import com.lobito.eatidentifiervip.domain.model.Session
import java.util.Date

@TypeConverters(TimeConverter::class)
@Entity(tableName = ConfiguracionGlobalEntity.TABLE_NAME)
data class ConfiguracionGlobalEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "createDate") val createDate: Date = Date(),
    @ColumnInfo(name = "activateConfigLocal") val activateConfigLocal: Int = ConfiguracionGlobalEntity.PENDING,
    @ColumnInfo(name = "autoLogin") val autoLogin: Int = ConfiguracionGlobalEntity.PENDING,

    ){
    companion object {
        const val TABLE_NAME = "ConfiguracionGlobalEntity"
        const val PENDING = 0
    }
}

