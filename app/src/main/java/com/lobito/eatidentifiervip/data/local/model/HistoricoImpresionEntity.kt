package com.lobito.eatidentifiervip.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.lobito.eatidentifiervip.data.local.converter.TimeConverter
import java.util.Date

@TypeConverters(TimeConverter::class)
@Entity(tableName = HistoricoImpresionEntity.TABLE_NAME)
data class HistoricoImpresionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "createDate") val createDate: Date = Date(),
    @ColumnInfo(name = "cui") val cui: String? = "",
    @ColumnInfo(name = "idEmpleado") val idEmpleado: String? = "",
    @ColumnInfo(name = "tipoComida") val tipoComida: String? = "",  // Nuevo campo genérico
    @ColumnInfo(name = "observaciones") val observaciones: String? = "",
    @ColumnInfo(name = "message") val message: String? = "",
    @ColumnInfo(name = "flagPrint") val flagPrint: Int? = PENDING,
    @ColumnInfo(name = "flagSync") val flagSync: Int? = PENDING
) {
    companion object {
        const val TABLE_NAME = "HistoricoImpresionEntity"
        const val PENDING = 0
        const val FINALIZED = 1
    }
}


