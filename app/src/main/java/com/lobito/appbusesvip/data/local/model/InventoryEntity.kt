package com.lobito.appbusesvip.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.lobito.appbusesvip.data.local.converter.TimeConverter
import java.util.Date


@TypeConverters(TimeConverter::class)
@Entity(tableName = InventoryEntity.TABLE_NAME)
data class InventoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "createDate") val createDate: Date = Date(),
    @ColumnInfo(name = "idInventario") val idInventario: String,
    @ColumnInfo(name = "empresa") val empresa: String,
    @ColumnInfo(name = "gerencia") val gerencia: String,
    @ColumnInfo(name = "area") val area: String,
    @ColumnInfo(name = "dni") val dni: String,
    @ColumnInfo(name = "sede") val sede: String,
    @ColumnInfo(name = "nombres") val nombres: String,
    @ColumnInfo(name = "apellidos") val apellidos: String,
    @ColumnInfo(name = "usuarioAnterior") val usuarioAnterior: String,
    @ColumnInfo(name = "usuarioDominio") val usuarioDominio: String,
    @ColumnInfo(name = "equipo") val equipo: String,
    @ColumnInfo(name = "lote") val lote: String,
    @ColumnInfo(name = "host") val host: String,
    @ColumnInfo(name = "marca") val marca: String,
    @ColumnInfo(name = "modelo") val modelo: String,
    @ColumnInfo(name = "serie") val serie: String,
    @ColumnInfo(name = "procesador") val procesador: String,
    @ColumnInfo(name = "memoria") val memoria: String,
    @ColumnInfo(name = "disco") val disco: String,
    @ColumnInfo(name = "macRed") val macRed: String,
    @ColumnInfo(name = "macWifi") val macWifi: String,
    @ColumnInfo(name = "estado") val estado: String,
    @ColumnInfo(name = "precioLote") val precioLote: String,
    @ColumnInfo(name = "licOffice") val licOffice: String,
    @ColumnInfo(name = "precioLicOffice") val precioLicOffice: String,
    @ColumnInfo(name = "licSap") val licSap: String,
    @ColumnInfo(name = "precioLicSap") val precioLicSap: String,
    @ColumnInfo(name = "licAntivirus") val licAntivirus: String,
    @ColumnInfo(name = "precioLicAntivirus") val precioLicAntivirus: String,
    @ColumnInfo(name = "obs") val obs: String

) {
    companion object {
        const val TABLE_NAME = "InventoryEntity"
        const val PENDING = 0    //PENDIENTE  // inicial
        const val TRUNK = -1     //TRUNCO     // final - error de contrasenia o error de peticiòn
        const val OPERATING = 1  //OPERANDO
        const val FINALIZED = 2  //FINALIZADO // final - cierre de apertura
    }
}
