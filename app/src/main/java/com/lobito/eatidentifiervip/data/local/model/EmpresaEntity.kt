package com.lobito.eatidentifiervip.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.lobito.eatidentifiervip.data.local.converter.TimeConverter
import com.lobito.eatidentifiervip.domain.model.Empresa
import java.util.Date

@TypeConverters(TimeConverter::class)
@Entity(tableName = EmpresaEntity.TABLE_NAME)
data class EmpresaEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")val id: Int = 0,
    @ColumnInfo(name = "createDate") val createDate: Date = Date(),
    @ColumnInfo(name = "idEmpresa")val idEmpresa: String,
    @ColumnInfo(name = "razonSocial")val razonSocial: String,
    @ColumnInfo(name = "razonComercial")val razonComercial: String,
    @ColumnInfo(name = "identificadorTributario")val identificadorTributario: String,
    @ColumnInfo(name = "direccion")val direccion: String,
    @ColumnInfo(name = "telefono")val telefono: String,
    @ColumnInfo(name = "email")val email: String,
    @ColumnInfo(name = "dateRegistro")val dateRegistro: String,
    @ColumnInfo(name = "dateModificacion")val dateModificacion: String,
    @ColumnInfo(name = "state")val state: Int,
    @ColumnInfo(name = "empresaSeleccionada")val empresaSeleccionada: Boolean = false
){
    companion object {
        const val TABLE_NAME = "EmpresaEntity"
    }
}

fun Empresa.toDatabase() = EmpresaEntity(
    idEmpresa = idEmpresa,
    razonSocial = razonSocial,
    razonComercial = razonComercial,
    identificadorTributario = identificadorTributario,
    direccion = direccion,
    telefono = telefono,
    email = email,
    dateRegistro = dateRegistro,
    dateModificacion =dateModificacion,
    state = state
)