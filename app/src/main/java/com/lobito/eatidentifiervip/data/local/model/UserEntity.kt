package com.lobito.eatidentifiervip.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.lobito.eatidentifiervip.data.local.converter.TimeConverter
import java.util.Date


@TypeConverters(TimeConverter::class)
@Entity(tableName = UserEntity.TABLE_NAME)
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "password") val password: String,
    @ColumnInfo(name = "createDate") val createDate: Date = Date(),
    @ColumnInfo(name = "flag") val flag: Int ?= 0,
) {
    companion object {
        const val TABLE_NAME = "UserEntity"
        const val PENDING = 0    //PENDIENTE  // inicial
        const val TRUNK = -1     //TRUNCO     // final - error de contrasenia o error de peticiòn
        const val OPERATING = 1  //OPERANDO
        const val FINALIZED = 2  //FINALIZADO // final - cierre de apertura
    }
}