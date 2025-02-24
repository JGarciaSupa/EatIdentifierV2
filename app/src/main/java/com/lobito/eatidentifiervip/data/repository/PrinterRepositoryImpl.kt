package com.lobito.eatidentifiervip.data.repository

import com.lobito.eatidentifiervip.data.printer.PrinterManager
import com.lobito.eatidentifiervip.di.PrinterType
import com.lobito.eatidentifiervip.domain.model.PrintData
import com.lobito.eatidentifiervip.domain.repository.PrinterRepository

class PrinterRepositoryImpl(
    private val printerManager: PrinterManager
) : PrinterRepository {
    override suspend fun print(data: PrintData, type: PrinterType) {
        printerManager.print(data, type)
    }
}

