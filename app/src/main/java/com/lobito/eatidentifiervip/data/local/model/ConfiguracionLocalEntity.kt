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
@Entity(tableName = ConfiguracionLocalEntity.TABLE_NAME)
data class ConfiguracionLocalEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "createDate") val createDate: Date = Date(),
    @ColumnInfo(name = "namePrinter") val namePrinter: String = "",
    @ColumnInfo(name = "flagPrinter") val flagPrinter: Int = ConfiguracionLocalEntity.PENDING,
    @ColumnInfo(name = "idUser") val idUser: Int = 0,
    ){
    companion object {
        const val TABLE_NAME = "ConfiguracionLocalEntity"
        const val PENDING = 0
    }
}

