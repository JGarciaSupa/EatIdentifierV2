package com.lobito.eatidentifiervip.domain.repository

import com.lobito.eatidentifiervip.di.PrinterType
import com.lobito.eatidentifiervip.domain.model.PrintData

interface PrinterRepository {
    suspend fun print(data: PrintData, type: PrinterType) // Agregar el parámetro type
}
