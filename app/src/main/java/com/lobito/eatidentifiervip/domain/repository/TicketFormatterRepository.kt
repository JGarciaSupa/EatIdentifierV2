package com.lobito.eatidentifiervip.domain.repository

import com.lobito.eatidentifiervip.domain.model.Empleado

interface TicketFormatterRepository {
    suspend fun presentationTicket() : ByteArray
    suspend fun printerModelOne(empleado : Empleado, tipoComida : String) : ByteArray
}
