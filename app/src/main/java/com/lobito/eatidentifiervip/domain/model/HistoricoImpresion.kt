package com.lobito.eatidentifiervip.domain.model

import com.lobito.eatidentifiervip.data.local.model.HistoricoImpresionEntity

data class HistoricoImpresion(
    val cui: String? = "",
    val idEmpleado: String? = "",
    val tipoComida: String? = "",  // Campo único para desayuno, almuerzo o cena
    val observaciones: String? = "",
    val message: String? = "",
    val flagPrint: Int? = HistoricoImpresionEntity.PENDING,
    val flagSync: Int? = HistoricoImpresionEntity.PENDING
)



fun HistoricoImpresion.toEntity() = HistoricoImpresionEntity(
    cui = cui,
    idEmpleado = idEmpleado,
    tipoComida = tipoComida,
    observaciones = observaciones,
    message = message,
    flagPrint = flagPrint,
    flagSync = flagSync
)

fun HistoricoImpresionEntity.toDomain() = HistoricoImpresion(
    cui = cui,
    idEmpleado = idEmpleado,
    tipoComida = tipoComida,
    observaciones = observaciones,
    message = message,
    flagPrint = flagPrint,
    flagSync = flagSync
)


