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
@Entity(tableName = EmpleadoEntity.TABLE_NAME)
data class EmpleadoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "createDate") val createDate: Date = Date(),
    @ColumnInfo(name = "idEmpleado") val idEmpleado: String,
    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "apellidos") val apellidos: String,
    @ColumnInfo(name = "fechaNacimiento") val fechaNacimiento: String,
    @ColumnInfo(name = "cui") val cui: String,
    @ColumnInfo(name = "telefono") val telefono: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "fechaRegistro") val fechaRegistro: String,
    @ColumnInfo(name = "estado") val estado: Int,
    @ColumnInfo(name = "idEmpresa") val idEmpresa: String,
    @ColumnInfo(name = "idConcesionaria") val idConcesionaria: String,
    @ColumnInfo(name = "idRole") val idRole: String,
    @ColumnInfo(name = "cargo") val cargo: String,
){
    companion object {
        const val TABLE_NAME = "EmpleadoEntity"
    }
}

fun Empleado.toDatabase() = EmpleadoEntity(
    idEmpleado = idEmpleado,
    nombre = nombre,
    apellidos = apellidos,
    fechaNacimiento = fechaNacimiento,
    cui = cui,
    telefono = telefono,
    email = email,
    fechaRegistro = fechaRegistro,
    estado = estado,
    idEmpresa = idEmpresa,
    idConcesionaria = idConcesionaria,
    idRole = idRole,
    cargo = cargo,
)