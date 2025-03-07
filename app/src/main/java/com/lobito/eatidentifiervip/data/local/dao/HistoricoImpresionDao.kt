package com.lobito.eatidentifiervip.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.lobito.eatidentifiervip.data.local.model.HistoricoImpresionEntity
import com.lobito.eatidentifiervip.data.local.model.SessionEntity

@Dao
interface HistoricoImpresionDao : BaseDao<HistoricoImpresionEntity> {

    @Query("SELECT * FROM HistoricoImpresionEntity")
    suspend fun getAll(): List<HistoricoImpresionEntity>


    @Query("SELECT * FROM HistoricoImpresionEntity WHERE idEmpleado = :idEmpleado AND tipoComida = :tipoComida AND DATE(createDate) = :fecha")
    suspend fun getHistoricoByEmpleado(idEmpleado: String, fecha: String, tipoComida: String): HistoricoImpresionEntity?

}