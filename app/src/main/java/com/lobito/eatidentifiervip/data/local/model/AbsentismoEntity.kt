package com.lobito.eatidentifiervip.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.lobito.eatidentifiervip.data.local.converter.TimeConverter
import java.util.Date


@TypeConverters(TimeConverter::class)
@Entity(tableName = AbsentismoEntity.TABLE_NAME)
data class AbsentismoEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "createDate") val createDate: Date = Date(),
    @ColumnInfo(name = "codTrabajador") val codTrabajador: String,
    @ColumnInfo(name = "dni") val dni: String,
    @ColumnInfo(name = "codEmpresa") val codEmpresa: String,
    @ColumnInfo(name = "apellidoMat") val apellidoMat: String,
    @ColumnInfo(name = "apellidoPat") val apellidoPat: String,
    @ColumnInfo(name = "nombres") val nombres: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "sexo") val sexo: String,
    @ColumnInfo(name = "estadoCivil") val estadoCivil: String,
    @ColumnInfo(name = "sedeNombre") val sedeNombre: String,
    @ColumnInfo(name = "posicionNombre") val posicionNombre: String,
    @ColumnInfo(name = "absentismo") val absentismo: String,
    @ColumnInfo(name = "licenciaDesc") val licenciaDesc: String,
    @ColumnInfo(name = "descripcion") val descripcion: String,
    @ColumnInfo(name = "areaNombre") val areaNombre: String

) {
    companion object {
        const val TABLE_NAME = "AbsentismoEntity"
        const val PENDING = 0    //PENDIENTE  // inicial
        const val TRUNK = -1     //TRUNCO     // final - error de contrasenia o error de peticiòn
        const val OPERATING = 1  //OPERANDO
        const val FINALIZED = 2  //FINALIZADO // final - cierre de apertura
    }
}

