package com.lobito.eatidentifiervip.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.lobito.eatidentifiervip.data.local.converter.TimeConverter
import com.lobito.eatidentifiervip.domain.model.Session
import java.util.Date

@TypeConverters(TimeConverter::class)
@Entity(tableName = SessionEntity.TABLE_NAME)
data class SessionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "createDate") val createDate: Date = Date(),
    @ColumnInfo(name = "email") val email: String = "",
    @ColumnInfo(name = "password") val password: String = "",
    @ColumnInfo(name = "idEmpresa") val idEmpresa: String,
    @ColumnInfo(name = "idUsuario") val idUsuario: String = "",
    @ColumnInfo(name = "nameUser") val nameUser: String = "",
    @ColumnInfo(name = "state") val state: Int = SessionEntity.PENDING,
){
    companion object {
        const val TABLE_NAME = "SessionEntity"
        const val PENDING = 0
        const val OPEN = 1
        const val CLOSE = 2
        const val TRUNK = -1
    }
}

//MANEJO DE ESTADOS
// 0 - PENDING
// 1 - OPEN SESSION
// 2 - CLOSE SESSION

fun Session.toDatabase() = SessionEntity(
    email = email,
    password = password,
    idEmpresa = idEmpresa,
    idUsuario = idUsuario?:"",
    nameUser = nameUser?:"",
    state = state?:0,
)
