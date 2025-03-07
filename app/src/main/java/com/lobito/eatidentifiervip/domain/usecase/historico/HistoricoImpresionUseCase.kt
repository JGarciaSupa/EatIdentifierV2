package com.lobito.eatidentifiervip.domain.usecase.historico

import com.lobito.eatidentifiervip.di.PrinterType
import com.lobito.eatidentifiervip.domain.model.Empleado
import com.lobito.eatidentifiervip.domain.model.HistoricoImpresion
import com.lobito.eatidentifiervip.domain.model.PrintData
import com.lobito.eatidentifiervip.domain.repository.HistoricoImpresionRepository
import com.lobito.eatidentifiervip.domain.repository.PrinterRepository

class HistoricoImpresionUseCase(
    private val historicoImpresionRepository: HistoricoImpresionRepository,
) {
    suspend operator fun invoke(historicoImpresion : HistoricoImpresion) {
        historicoImpresionRepository.insertHistoricoImpresion(historicoImpresion = historicoImpresion)
    }
}
