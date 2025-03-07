package com.lobito.eatidentifiervip.domain.repository

import com.lobito.eatidentifiervip.domain.model.Empleado
import com.lobito.eatidentifiervip.domain.model.HistoricoImpresion

interface HistoricoImpresionRepository {
    suspend fun insertHistoricoImpresion(historicoImpresion: HistoricoImpresion)
    suspend fun getHistoricoImpresion(): List<HistoricoImpresion>
    suspend fun getHistoricoByEmpleado(idEmpleado: String, fecha: String, tipoComida: String) : HistoricoImpresion?
}
