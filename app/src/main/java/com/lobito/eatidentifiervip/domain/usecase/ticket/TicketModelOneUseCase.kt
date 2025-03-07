package com.lobito.eatidentifiervip.domain.usecase.ticket

import com.lobito.eatidentifiervip.di.PrinterType
import com.lobito.eatidentifiervip.domain.model.Empleado
import com.lobito.eatidentifiervip.domain.model.PrintData
import com.lobito.eatidentifiervip.domain.repository.PrinterRepository
import com.lobito.eatidentifiervip.domain.repository.TicketFormatterRepository

class TicketModelOneUseCase(
    private val ticketFormatterRepository: TicketFormatterRepository,
) {
    suspend operator fun invoke(empleado: Empleado, tipoComida : String) {
        ticketFormatterRepository.printerModelOne(empleado = empleado, tipoComida = tipoComida)
    }
}
