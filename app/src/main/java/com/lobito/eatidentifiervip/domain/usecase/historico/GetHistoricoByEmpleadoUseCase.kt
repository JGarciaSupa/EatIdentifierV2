package com.lobito.eatidentifiervip.domain.usecase.historico

import com.lobito.eatidentifiervip.domain.repository.HistoricoImpresionRepository

class GetHistoricoByEmpleadoUseCase (
    private val historicoImpresionRepository: HistoricoImpresionRepository,
) {
    suspend operator fun invoke(idEmpleado: String, fecha: String, tipoComida: String) {
        historicoImpresionRepository.getHistoricoByEmpleado(idEmpleado, fecha, tipoComida)
    }
}
