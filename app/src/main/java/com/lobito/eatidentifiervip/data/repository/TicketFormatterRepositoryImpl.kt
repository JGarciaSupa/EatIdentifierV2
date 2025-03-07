package com.lobito.eatidentifiervip.data.repository


import com.lobito.eatidentifiervip.data.local.tickets.TicketFormmaterLocal
import com.lobito.eatidentifiervip.domain.model.Empleado
import com.lobito.eatidentifiervip.domain.repository.TicketFormatterRepository

class TicketFormatterRepositoryImpl(
    private val ticketFormatterLocal : TicketFormmaterLocal
    ) : TicketFormatterRepository {

    override suspend fun presentationTicket(): ByteArray{
        return ticketFormatterLocal.getTicketPresentation()
    }

    override suspend fun printerModelOne(empleado : Empleado, tipoComida : String): ByteArray {
       return ticketFormatterLocal.getTicketEmpleado(empleado = empleado, tipoComida = tipoComida)
    }


}