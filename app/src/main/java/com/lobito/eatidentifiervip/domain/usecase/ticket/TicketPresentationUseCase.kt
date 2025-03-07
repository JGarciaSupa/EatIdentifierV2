package com.lobito.eatidentifiervip.domain.usecase.ticket

import com.lobito.eatidentifiervip.di.PrinterType
import com.lobito.eatidentifiervip.domain.model.PrintData
import com.lobito.eatidentifiervip.domain.repository.PrinterRepository
import com.lobito.eatidentifiervip.domain.repository.TicketFormatterRepository

class TicketPresentationUseCase(
    private val ticketFormatterRepository: TicketFormatterRepository,
) {
    suspend operator fun invoke() {
        ticketFormatterRepository.presentationTicket()
    }
}
